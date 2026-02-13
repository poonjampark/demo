//package com.pzp.mq.kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ConsumerSend {
//
//	@KafkaListener(topics = "kafkaTopicA", groupId = "myGroup")
//	public void consume(String msg) {
//		System.out.println("接收到kafka测试消息并消费成功：" + msg);
//	}
//	
//}
