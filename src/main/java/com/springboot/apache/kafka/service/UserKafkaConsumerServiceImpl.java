package com.springboot.apache.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.springboot.apache.kafka.payload.User;

@Component
public class UserKafkaConsumerServiceImpl implements UserKafkaConsumerService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserKafkaConsumerServiceImpl.class);
	
	@KafkaListener(topics="user_information", groupId="myGroup")
	@Override
	public void consume(User user) {

		LOGGER.info("==consume the information from broker=="+user);
	}

}
