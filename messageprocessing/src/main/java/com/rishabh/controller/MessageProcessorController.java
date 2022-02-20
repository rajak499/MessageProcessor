package com.rishabh.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.generic.WriteCsv;
import com.rishabh.modal.MessageProcessor;
import com.rishabh.service.MessageProcessorService;

@RestController
public class MessageProcessorController {
	
	@Autowired
	MessageProcessorService messageProcessorService;
	

	
	@GetMapping(value = "/getdetail")
	public List<MessageProcessor> getTrnsactiondata() {
		return  messageProcessorService.getAllMessages();
		
	}
	
	@GetMapping(value = "/getdetail/{id}")
	public MessageProcessor getTrnsactiondatabyID(@PathVariable("id") UUID id) {
		return  messageProcessorService.getMessagebyID(id);
		
	}
	
	@PostMapping(value = "/postdetail" , consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public MessageProcessor addTransactiondata(@RequestBody MessageProcessor messageProcessor) {	
		return messageProcessorService.save(messageProcessor);
		
	}
	
	@GetMapping(value = "/getdetailCSV" ,produces = "text/csv")
    public void getTrnsactiondataCSV(HttpServletResponse response) throws IOException {

		List<MessageProcessor> list = messageProcessorService.getAllMessages();
        WriteCsv.writeTransactions(response.getWriter(), list);
    }

}
