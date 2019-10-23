package com.vicky.dojooverview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.dojooverview.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {

}
