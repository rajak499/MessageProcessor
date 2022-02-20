package com.rishabh.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.dao.MessageProcessorDao;
import com.rishabh.modal.MessageProcessor;
import com.rishabh.publisher.Publisher;

@Service
public class MessageProcessorServiceImpl implements MessageProcessorService{

	
	@Autowired
	MessageProcessorDao messageProcessorDao;
	
	@Autowired
	Publisher publisher;
	
	private static Integer publisherKey = 1;
	
	@Override
	public MessageProcessor save(MessageProcessor messageProcessor) {
		messageProcessor.setTransactionId(UUID.randomUUID());
		publisher.addMessageQueuess(publisherKey++, messageProcessor);
		return messageProcessorDao.save(messageProcessor);
	}

	@Override
	public List<MessageProcessor> getAllMessages() {		
		return (List<MessageProcessor>)messageProcessorDao.findAll();
	}

	@Override
	public MessageProcessor getMessagebyID(UUID transactionID) {
		return messageProcessorDao.findBytransactionId(transactionID);
	}


}
