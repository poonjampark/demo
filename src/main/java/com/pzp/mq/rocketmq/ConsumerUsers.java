package com.pzp.mq.rocketmq;

import java.util.List;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
topic = "topicC",
consumerGroup = "consumer-users",
selectorExpression = "tagC"
)
public class ConsumerUsers implements RocketMQListener<List<String>> {

	@Override
	public void onMessage(List<String> message) {
		message.forEach(account -> System.out.println("已消费消息:" + account));
	}

}