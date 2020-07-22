package com.startaideia.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import com.startaideia.desafio.model.Tool;

public interface ToolRepository extends CrudRepository<Tool, Long> {
}
