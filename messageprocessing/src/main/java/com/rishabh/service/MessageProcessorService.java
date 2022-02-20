package com.rishabh.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rishabh.modal.MessageProcessor;

@Service
public interface MessageProcessorService {
	
	public MessageProcessor save(MessageProcessor messageProcessor);
	
	public List<MessageProcessor> getAllMessages();
	
	public MessageProcessor getMessagebyID(UUID transactionID);



}
