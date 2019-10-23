package com.vicky.projecttest.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.projecttest.model.Idea;


@Repository

public interface IdeaRepository extends CrudRepository <Idea, Long>{

}
