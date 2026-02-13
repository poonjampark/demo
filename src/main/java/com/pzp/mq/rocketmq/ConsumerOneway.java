//package com.pzp.mq.rocketmq;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(
//topic = "oneway-topic",
//selectorExpression = "tagE",
//consumerGroup = "oneway-consumer"
//)
//public class ConsumerOneway implements RocketMQListener<String> {
//
//	@Override
//	public void onMessage(String message) {
//		System.out.println("单向消费消息：" + message);
//	}
//
//}
