package com.startaideia.desafio.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.startaideia.desafio.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {
}
