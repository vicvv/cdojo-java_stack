package com.vicky.eventsbeltreviewer.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.eventsbeltreviewer.models.Event;
import com.vicky.eventsbeltreviewer.models.User;

@Repository
public interface EventRepository extends CrudRepository <Event, Long> {

//	@Query(value="SELECT * from users_likes where event_id = 1", nativeQuery=true)
//	List<Event> findAllEventLikes(Long id);

}
