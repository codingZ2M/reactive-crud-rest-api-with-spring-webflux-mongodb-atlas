package com.codingz2m.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.springbootkafka.kafka.KafkaConsumer;
import com.codingz2m.springbootkafka.kafka.KafkaProducer;
import com.codingz2m.springbootkafka.model.MutualFund;

@RestController
@RequestMapping("/mutualfund/v1")
public class KafkaMessageController {
	
	private KafkaProducer kafkaProducer;
	//private KafkaConsumer kafkaConsumer;

	@Autowired
	public KafkaMessageController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	//	this.kafkaConsumer = kafkaConsumer;
	}

	@PostMapping
	public ResponseEntity<String> publishMutualFundScheme(@RequestBody MutualFund mutualFund){
		
		kafkaProducer.sendMessage(mutualFund);
		return ResponseEntity.ok("Message has been sent or Kafka Producer!");
	}

	
}
