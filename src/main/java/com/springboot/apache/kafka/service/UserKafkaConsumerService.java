package com.springboot.apache.kafka.service;

import org.springframework.stereotype.Service;

import com.springboot.apache.kafka.payload.User;

@Service
public interface UserKafkaConsumerService {

	public void consume(User user);
}
