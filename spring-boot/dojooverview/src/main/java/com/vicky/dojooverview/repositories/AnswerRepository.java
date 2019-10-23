package com.vicky.dojooverview.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.dojooverview.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
