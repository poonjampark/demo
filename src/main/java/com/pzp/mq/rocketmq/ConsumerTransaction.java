//package com.pzp.mq.rocketmq;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(
//topic = "transaction-topic",
//selectorExpression = "tagH",
//consumerGroup = "transaction-group"
//)
//public class ConsumerTransaction implements RocketMQListener<String> {
//
//	@Override
//	public void onMessage(String message) {
//		System.out.println("事务消息已消费:" + message);
//	}
//	
//}
