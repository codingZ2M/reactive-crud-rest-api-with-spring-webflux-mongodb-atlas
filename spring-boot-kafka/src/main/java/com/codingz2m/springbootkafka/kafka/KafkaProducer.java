package com.codingz2m.springbootkafka.kafka;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.codingz2m.springbootkafka.model.MutualFund;

@Service
public class KafkaProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	// Used to send message to Kafka broker
	private KafkaTemplate<String, MutualFund> kafkaTemplate;

	
	public KafkaProducer(KafkaTemplate<String, MutualFund> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(MutualFund mutualFund) {
		LOGGER.info(String.format("Message has been sent to Kafka Broker %s", mutualFund.toString()));
		
		Message<MutualFund> message = MessageBuilder.withPayload(mutualFund)
				.setHeader(KafkaHeaders.TOPIC, "mutualfundschemes" )
				.build();
				
		kafkaTemplate.send(message);
		
	}
}
