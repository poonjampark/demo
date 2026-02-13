//package com.pzp.mq.rocketmq;
//
//import org.apache.rocketmq.spring.annotation.ConsumeMode;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@RocketMQMessageListener(
//topic = "orderly-topic",
//selectorExpression = "tagG",
//consumerGroup = "orderly-consumer",
//consumeMode = ConsumeMode.ORDERLY
//)
//public class ConsumerOrderly implements RocketMQListener<String> {
//
//	@Override
//	public void onMessage(String message) {
//		System.out.println("顺序消费消息：" + message);
//	}
//
//}
