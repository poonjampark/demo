//package com.pzp.mq.rocketmq;
//
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//import com.pzp.model.User;
//
//@Component
//@RocketMQMessageListener(
//topic = "topicB",
//consumerGroup = "consumer-user",
//selectorExpression = "tagB"
//)
//public class ConsumerUser implements RocketMQListener<User> {
//
//	@Override
//	public void onMessage(User user) {
//		System.out.println("已消费消息:" + user);
//	}
//
//}
