package com.rishabh.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.modal.MessageProcessor;

@Repository
public interface MessageProcessorDao extends CrudRepository<MessageProcessor,Integer>{

	MessageProcessor findBytransactionId(UUID transactionID);

}
