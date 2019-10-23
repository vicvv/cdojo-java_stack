package com.vicky.dojooverview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.dojooverview.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByTEquals(String t);
}
