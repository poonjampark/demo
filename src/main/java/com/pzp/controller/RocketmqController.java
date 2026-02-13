//package com.pzp.controller;
//
//import java.util.List;
//
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.pzp.model.User;
////import com.pzp.mq.rocketmq.TransactionService;
//
//@RestController
//public class RocketmqController {
//
//	@Autowired
//	private RocketMQTemplate rocketMQTemplate;
//	
//	@GetMapping("/msg/{msg}")
//	public String sendSyncMsg(@PathVariable String msg) {
//		rocketMQTemplate.convertAndSend("topicA:tagA", msg);
//		return "消息已发送";
//	}
//	
//	@PostMapping("/msg/user")
//	public User sendUser(@RequestBody User user) {
//		rocketMQTemplate.convertAndSend("topicB:tagB", user);
//		return user;
//	}
//	
//	@PostMapping("/msg/users")
//	public List<String> sendUsers(@RequestBody List<String> accounts) {
//		rocketMQTemplate.convertAndSend("topicC:tagC", accounts);
//		return accounts;
//	}
//	
//	@GetMapping("/syncMsg/{msg}")
//	public String syncSend(@PathVariable String msg) {
//		SendResult sendResult = rocketMQTemplate.syncSend("topicA:tagA", msg);
//		return "同步消息已发送:" + sendResult.getMsgId();
//	}
//	
//	@GetMapping("/asyncMsg/{msg}")
//	public String asyncSend(@PathVariable String msg) {
//		rocketMQTemplate.asyncSend("async-topic:tagD", msg, new SendCallback() {
//
//			@Override
//			public void onSuccess(SendResult sendResult) {
//				System.out.println("发送异步消息成功" + sendResult);
//			}
//
//			@Override
//			public void onException(Throwable e) {
//				System.out.println("发送异步消息失败" + e.getMessage());
//			}
//			
//		});
//		return msg;
//	}
//	
//	@GetMapping("/onewaymsg/{msg}")
//	public String sendOneWay(@PathVariable String msg) {
//		rocketMQTemplate.sendOneWay("oneway-topic:tagE", msg);
//		return "单向消息已发送" + msg;
//	}
//	
//	@GetMapping("/delaymsg/{msg}")
//	public String delaySend(@PathVariable String msg) {
//		Message message = new Message("delay-topic", "tagF", msg.getBytes());
//		message.setDelayTimeLevel(4);
//		rocketMQTemplate.syncSend("abc", msg);
////		rocketMQTemplate.syncSend("delay-topic:tagF", MessageBuilder.withPayload(msg).build(),30000, 5);
//		return "延迟消息已发送:" + msg;
//	}
//	
//	@GetMapping("/orderlymsg/{msg}")
//	public String orderlySend(@PathVariable String msg) {
//		for (int i = 0; i < 10; i++) {
//			rocketMQTemplate.syncSendOrderly("orderly-topic:tagG", "顺序消息:" + msg + i, "order_001");
//		}
//		return "顺序消息已发送:" + msg;
//	}
//	
////	@GetMapping("/transactionmsg/{msgStr}")
////	public String transactionSend(@PathVariable String msgStr) {
////		TransactionListener transactionListener = new TransactionService();
////		TransactionMQProducer producer = new TransactionMQProducer("tx-group");
////		producer.setTransactionListener(transactionListener);
////		Message msg;
////		try {
////			producer.start();
////			msg = new Message("transaction-topic", "tagH", msgStr.getBytes("UTF-8"));
////			producer.sendMessageInTransaction(msg, null);
////			producer.shutdown();
////		} catch (UnsupportedEncodingException e) {
////			e.printStackTrace();
////		} catch (MQClientException e) {
////			e.printStackTrace();
////		}
////		return "事务消息已发送:" + msgStr;
////	}
//	
//	@GetMapping("/transactionmsg/{msgStr}")
//	public String transactionSend(@PathVariable String msgStr) {
//		rocketMQTemplate.sendMessageInTransaction("transaction-topic:tagH", MessageBuilder.withPayload(msgStr).build(), msgStr);
//		return "事务消息已发送:" + msgStr;
//	}
//	
//}