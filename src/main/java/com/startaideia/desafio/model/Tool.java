package com.startaideia.desafio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tools")
public class Tool {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Título é um campo obrigatório")
    private String title;

    @NotNull(message = "Link é um campo obrigatório")
    private String link;
    
    @NotNull(message = "Descrição é um campo obrigatório")
    private String description;
    
    @ManyToMany
    @JoinTable(
    		  name = "tools_tags", 
    		  joinColumns = @JoinColumn(name = "tag_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "tool_id"))
    private List<Tag> tags;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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

	public List<Tag> getTags() {
		return tags;
	}
	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
    
}
