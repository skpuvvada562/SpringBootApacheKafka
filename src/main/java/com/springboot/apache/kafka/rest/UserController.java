package com.springboot.apache.kafka.rest;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apache.kafka.payload.User;
import com.springboot.apache.kafka.service.UserKafkaProducerService;

@RestController
@RequestMapping("/kafka/api/v1")
public class UserController {

	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserKafkaProducerService userProducerService;
	
	@PostMapping(value="/publish", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> publishUser(@RequestBody User user) throws InterruptedException, ExecutionException{
		LOGGER.info("sending user information to the topic::"+user);
		
		userProducerService.publishUserInfo(user);
		
		LOGGER.info("Publish the topic successfully");
		
		return new ResponseEntity<String>("Publish the topic successfully", HttpStatus.CREATED);
	}
}
