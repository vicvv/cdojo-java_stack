package com.vicky.projecttest.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.projecttest.model.User;



@Repository

public interface UserRepository extends CrudRepository <User, Long> {
	User findByEmail(String email);

//	@Query(value="SELECT * FROM eventsbelts1.users_likes WHERE event_id = ?1;", nativeQuery=true)
//	List<User> findAllEventLikes(Long id);
}
