//package com.pzp.mq.rocketmq;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(
//topic = "delay-topic",
//selectorExpression = "tagF",
//consumerGroup = "delay-consumer"
//)
//public class ConsumerDelay implements RocketMQListener<String> {
//
//	@Override
//	public void onMessage(String message) {
//		System.out.println("延迟消费消息：" + message);
//	}
//
//}