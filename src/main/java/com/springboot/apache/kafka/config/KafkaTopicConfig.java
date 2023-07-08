package com.springboot.apache.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic getTopic(){
		return TopicBuilder.name("user_information")
						   .partitions(10)
						   .replicas(2)
						   .build();
	}
}
