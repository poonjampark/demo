//package com.pzp.interceptor;
//
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.apache.kafka.clients.producer.ProducerInterceptor;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//
//public class KafkaInterceptor implements ProducerInterceptor<String, String> {
//
//	@Override
//	public void configure(Map<String, ?> configs) {
//		System.out.println("configure start");
//		for (Entry<String, ?> entry : configs.entrySet()) {
//			System.out.println(entry.getKey() + entry.getValue());
//		}
//		System.out.println("configure end");
//	}
//
//	@Override
//	public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
//		System.out.println(record);
//		return null;
//	}
//
//	@Override
//	public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
//		System.out.println(metadata.toString());
//	}
//
//	@Override
//	public void close() {
//		System.out.println("producer close");
//	}
//
//}
