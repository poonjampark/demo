//package com.pzp.config.redis;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.client.codec.StringCodec;
//import org.redisson.config.Config;
//import org.redisson.config.ReadMode;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedissonConfig {
//
//	private static String ADDRESS_PREFIX = "redis://";
//
//	@Value("${spring.redisson.cluster}")
//	private String clusterNodes;
//
//	@Bean
//	public RedissonClient redissonCluster() {
//		String[] nodes = clusterNodes.split(",");
//		// redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
//		for (int i = 0; i < nodes.length; i++) {
//			nodes[i] = ADDRESS_PREFIX + nodes[i];
//		}
//		Config config = new Config();
//		// 设置
//		config.setCodec(new StringCodec())
//				// 这是用的集群server
//				.useClusterServers()
//				// 设置集群状态扫描时间
//				.setScanInterval(6000).addNodeAddress(nodes).setReadMode(ReadMode.MASTER);
//		return Redisson.create(config);
//	}
//
//}
