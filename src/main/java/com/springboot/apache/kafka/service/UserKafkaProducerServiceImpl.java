package com.springboot.apache.kafka.service;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.springboot.apache.kafka.payload.User;

@Component
public class UserKafkaProducerServiceImpl implements UserKafkaProducerService {

	private static final Logger LOGGER=LoggerFactory.getLogger(UserKafkaProducerServiceImpl.class);
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@Override
	public void publishUserInfo(User user) throws InterruptedException, ExecutionException {

		Message<User> message = MessageBuilder.withPayload(user)
											  .setHeader(KafkaHeaders.TOPIC, "user_information")
											  .build();
		ListenableFuture<SendResult<String, User>> response=kafkaTemplate.send(message);
		
		LOGGER.info("==in service==="+response.completable().get().getProducerRecord());

	}

}
