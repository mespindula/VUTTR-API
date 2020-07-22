package com.startaideia.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.startaideia.desafio.dto.ToolDTO;
import com.startaideia.desafio.model.Tag;
import com.startaideia.desafio.model.Tool;
import com.startaideia.desafio.repository.ToolRepository;

@Service
public class ToolService {

	@Autowired
	private ToolRepository toolRepository;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private Mapper mapper;
	
	public Tool create(@Valid final ToolDTO tool) {
		
		Tool toolEntity = mapper.map(tool, Tool.class);
		List<Tag> tags = new ArrayList<Tag>();
		
		tool.getTags().forEach(tagName -> {

			Optional<Tag> optTag = tagService.findByTagName(tagName);
	    	Tag tag = new Tag();
	    	
	    	if (!optTag.isPresent()) {
				tag.setTagName(tagName);
				tagService.save(tag);
	    	} else {
	    		tag = optTag.get();
	    	}

			tags.add(tag);
		});
		
		toolEntity.setTags(tags);
		
		return toolRepository.save(toolEntity);
    }
	
	public Iterable<Tool> findAll() {
		return toolRepository.findAll();
	}
	
	public void delete(Long id) {
		Tool tool = new Tool();
		tool.setId(id);
		toolRepository.delete(tool);
	}
	
	public Iterable<Tool> findByTagName(String tagName) {
		Optional<Tag> optTag = tagService.findByTagName(tagName);
		return optTag.isPresent() ? optTag.get().getTools() : new ArrayList<Tool>();
	}
}
