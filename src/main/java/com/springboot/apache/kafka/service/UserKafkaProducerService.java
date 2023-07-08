package com.springboot.apache.kafka.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.springboot.apache.kafka.payload.User;

@Service
public interface UserKafkaProducerService {

	public void publishUserInfo(User user) throws InterruptedException, ExecutionException;
}
