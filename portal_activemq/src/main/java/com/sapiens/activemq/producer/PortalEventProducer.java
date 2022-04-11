package com.sapiens.activemq.producer;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapiens.activemq.dto.Student;

@RestController
@RequestMapping("/produce")
public class PortalEventProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private Queue<?> queue;

	@PostMapping("/message")
	public Student sendMessage(@RequestBody Student student) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			String studentAsJson = mapper.writeValueAsString(student);
			queue.getClass().getName();
			jmsTemplate.convertAndSend("netsurfingzone-queue",studentAsJson );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
}
