package com.rishabh.publisher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.modal.MessageProcessor;
import com.rishabh.utility.Constant;

@Service
public class Publisher extends Thread{
	
	 @Autowired
	 private  RabbitTemplate template;
	 
	 private static Map<Integer,MessageProcessor> messageToPublish= new HashMap<>();
	 
	 
	 public  void addMessageQueuess(Integer key,MessageProcessor messageProcessor) {
		 
		 messageToPublish.put(key, messageProcessor);
		 messageToPublish.forEach((key1,messageProcessor1) -> {
			 synchronized(this){
				 template.convertAndSend(Constant.EXCHANGE, Constant.ROUTING_KEY, messageProcessor);
				 isConsumed();
			 }});	
			 
	 }
	 
	 
	 public static boolean isConsumed() {
		 try {
			if(!Constant.consumedFlag) {
				Thread.sleep(3);
				isConsumed();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Constant.consumedFlag;
	 }
		 

}
