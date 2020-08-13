package com.devs4j.users.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Devs4jMessageListener {

	@KafkaListener(topics = "devs4j-topic", groupId = "consumer")
	public void listen(String message) {
		System.out.println("Received Messasge in group foo: " + message);
	}
}
