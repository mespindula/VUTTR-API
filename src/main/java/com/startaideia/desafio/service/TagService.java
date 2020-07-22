package com.startaideia.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startaideia.desafio.model.Tag;
import com.startaideia.desafio.repository.TagRepository;
import com.startaideia.desafio.repository.specs.SearchCriteria;
import com.startaideia.desafio.repository.specs.SearchOperation;
import com.startaideia.desafio.repository.specs.TagSpecification;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public Optional<Tag> findByTagName(String tagName) {
		TagSpecification spec = new TagSpecification();
    	spec.add(new SearchCriteria("tagName", tagName, SearchOperation.EQUAL));
    	return tagRepository.findOne(spec);
	}
}
