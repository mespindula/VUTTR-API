package com.startaideia.desafio.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class ToolDTO {

    private long id;

    @NotNull(message = "Título é um campo obrigatório")
    private String title;

    @NotNull(message = "Link é um campo obrigatório")
    private String link;
    
    @NotNull(message = "Descrição é um campo obrigatório")
    private String description;
    
    @NotNull(message = "Informe ao menos uma tag")
    List<String> tags;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public void addTag(String tag) {
		if (tags == null) {
			tags = new ArrayList<String>();
		}
		tags.add(tag);
	}
    
}
