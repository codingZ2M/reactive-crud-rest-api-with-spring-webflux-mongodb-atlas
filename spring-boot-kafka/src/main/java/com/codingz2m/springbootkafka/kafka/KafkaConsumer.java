package com.codingz2m.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.codingz2m.springbootkafka.model.MutualFund;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="mutualfundschemes", groupId="mutualFundInvestors")
	public void consumeMessage(MutualFund mutualFund) {
		
		LOGGER.info(String.format("Message has been received from Kafka Broker %s", mutualFund.toString()));
		
	}

}
