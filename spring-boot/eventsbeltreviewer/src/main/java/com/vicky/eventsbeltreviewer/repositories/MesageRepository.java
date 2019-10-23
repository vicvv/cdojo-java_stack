package com.vicky.eventsbeltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.eventsbeltreviewer.models.Message;

@Repository

public interface MesageRepository extends CrudRepository <Message, Long>{

}
