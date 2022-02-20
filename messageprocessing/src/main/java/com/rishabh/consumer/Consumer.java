package com.rishabh.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rishabh.modal.MessageProcessor;
import com.rishabh.utility.Constant;

@Component
public class Consumer {
	
    @RabbitListener(queues = Constant.QUEUE)
    public void consumeMessageFromQueue(MessageProcessor messageProcessor) {
        System.out.println("Message recieved from queue with Transaction ID : " + messageProcessor.getTransactionId());
        Constant.consumedFlag = true;
    }

}
