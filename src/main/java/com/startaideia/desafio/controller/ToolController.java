package com.startaideia.desafio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.dozermapper.core.Mapper;
import com.startaideia.desafio.dto.ToolDTO;
import com.startaideia.desafio.model.Tool;
import com.startaideia.desafio.service.ToolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tools")
@Api(value="API Rest Ferramentas")
public class ToolController {
	
	@Autowired
	private ToolService toolService;
	
	@Autowired
	private Mapper mapper;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma nova ferramenta e salva na base de dados")
    public ToolDTO create(@RequestBody final ToolDTO dto) {
		
		Tool tool = toolService.create(dto);
				
		ToolDTO toolDTO = mapper.map(tool, ToolDTO.class);
		toolDTO.setTags(new ArrayList<String>());
		
		tool.getTags().forEach(tag  -> toolDTO.addTag(tag.getTagName()));
		
		return toolDTO;
    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deleta uma ferramenta conforme o ID informado")
	public ResponseEntity delete(@PathVariable final Long id) {
		toolService.delete(id);
		return ResponseEntity.noContent().build();
	}
     
	@GetMapping
	@ApiOperation(value = "Lista todas as ferramentas cadastradas na base de dados")
    public List<ToolDTO> list() {
		List<ToolDTO> dtoList = new ArrayList<ToolDTO>();
    	Iterable<Tool> tools = toolService.findAll();

    	tools.forEach(tool -> {
    		ToolDTO dto = mapper.map(tool, ToolDTO.class);
    		dto.setTags(new ArrayList<String>());
    		 
    		tool.getTags().forEach(tag -> {
    			dto.addTag(tag.getTagName());
    		});
    		dtoList.add(dto);
    	});
 
         return dtoList;
     }
     
	 @GetMapping("{tag}")
     @ApiOperation(value = "Lista as ferramentas conforme a TAG informada")
     public List<ToolDTO> getByTag(@RequestParam(name = "tag", required = false) final String tagName) {
    	 List<ToolDTO> dtoList = new ArrayList<ToolDTO>();
    	 Iterable<Tool> tools = toolService.findByTagName(tagName);
    	 
    	 tools.forEach(tool -> {
    		 ToolDTO dto = mapper.map(tool, ToolDTO.class);
    		 dto.setTags(new ArrayList<String>());
    		 
    		 tool.getTags().forEach(tag -> {
    			 dto.addTag(tag.getTagName());
    		 });
    		 dtoList.add(dto);
    	 });
 
         return dtoList;
     }
     
	 @GetMapping("/title/{title}")
     @ApiOperation(value = "Lista as ferramentas conforme o título informado")
     public List<ToolDTO> getByTitle(@PathVariable final String title) {
    	 List<ToolDTO> dtoList = new ArrayList<ToolDTO>();
    	 Iterable<Tool> tools = toolService.findByTitle(title);
    	 
    	 tools.forEach(tool -> {
    		 ToolDTO dto = mapper.map(tool, ToolDTO.class);
    		 dto.setTags(new ArrayList<String>());
    		 
    		 tool.getTags().forEach(tag -> {
    			 dto.addTag(tag.getTagName());
    		 });
    		 dtoList.add(dto);
    	 });
 
         return dtoList;
     }

}
