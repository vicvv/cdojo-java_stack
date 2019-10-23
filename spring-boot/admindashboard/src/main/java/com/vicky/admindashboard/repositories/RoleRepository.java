package com.vicky.admindashboard.repositories;

import org.springframework.stereotype.Repository;

import com.vicky.admindashboard.models.Role;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	List<Role> findAll();	  
    List<Role> findByName(String name);
}
