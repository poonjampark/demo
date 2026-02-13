//package com.pzp.config.kafka;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//@Configuration
//public class KafkaConfig {
//
//	@Bean
//	public KafkaTemplate<String, String> kafkaTemplate() {
//		return new KafkaTemplate<>(producerFactory());
//	}
//	
//	@Bean
//	public ProducerFactory<String, String> producerFactory() {
//		Map<String, Object> configs = new HashMap<>();
//
//		configs.put("transactional.id", "my-transactional-id"); // 唯一的事务ID
//
//		// Kafka broker地址
//		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		// Key序列化类
//		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//	    // Value序列化类
//		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//	    // 分区器类，如果需要自定义分区策略，也可以在这里设置自定义的分区器类路径。
//		configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, DefaultPartitioner.class);
//		configs.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, "com.pzp.interceptor.KafkaInterceptor");
//		return new DefaultKafkaProducerFactory<>(configs);
//		
//	}
//	
//}
