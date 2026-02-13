/*
 * package com.pzp.config.redis;
 * 
 * import java.util.Arrays;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.cache.annotation.EnableCaching; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.redis.connection.RedisClusterConfiguration; import
 * org.springframework.data.redis.connection.RedisConnectionFactory; import
 * org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
 * import org.springframework.data.redis.core.StringRedisTemplate;
 * 
 * @Configuration
 * 
 * @EnableCaching public class RedisConfig {
 * 
 * @Value("${spring.data.redis.cluster.nodes}") private String clusterNodes;
 * 
 * @Bean public RedisConnectionFactory redisConnectionFactory() {
 * RedisClusterConfiguration clusterConfiguration = new
 * RedisClusterConfiguration( Arrays.asList(clusterNodes.split(","))); return
 * new LettuceConnectionFactory(clusterConfiguration); }
 * 
 * @Bean public StringRedisTemplate redisTemplate() { StringRedisTemplate
 * template = new StringRedisTemplate();
 * template.setConnectionFactory(redisConnectionFactory()); return template; }
 * 
 * }
 */