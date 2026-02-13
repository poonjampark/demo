//package com.pzp.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/kafka")
//public class KafkaController {
//
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//	
//	@GetMapping("/send/{msg}")
//	public String send(@PathVariable String msg) {
//		kafkaTemplate.send("kafkaTopicA", msg);
//		return "kafka消息发送成功";
//	}
//	
//}
