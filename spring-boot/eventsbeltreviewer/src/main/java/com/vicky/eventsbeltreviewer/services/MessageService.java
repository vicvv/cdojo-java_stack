package com.vicky.eventsbeltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vicky.eventsbeltreviewer.models.Message;
import com.vicky.eventsbeltreviewer.repositories.MesageRepository;

@Service
public class MessageService {
	
	private final MesageRepository messageRepository;
	
	public MessageService(MesageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	// all messages
	public List<Message> findAllMessages(){
		return (List<Message>)messageRepository.findAll();
	}
	// create one message
	public Message createMessage(Message message) {
		return messageRepository.save(message);
	}
	// delete message
	public void deleteMessage(Message message) {
		messageRepository.delete(message);
	}
	// find message by Id
	public Message findMessageById(Long id) {
    	Optional<Message> message = messageRepository.findById(id);
    	if(message.isPresent()) {
            return message.get();
    	}
    	else {
    	    return null;
    	}
    }
	
	
}
