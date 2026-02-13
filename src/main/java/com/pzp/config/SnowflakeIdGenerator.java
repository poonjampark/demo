//package com.pzp.config;
//
//import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
//import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SnowflakeIdGenerator {
//	
//    // 初始化雪花算法生成器
//    private final ShardingKeyGenerator snowflakeKeyGenerator = new SnowflakeShardingKeyGenerator();
//
//    public SnowflakeIdGenerator() {
//        // 设置工作节点ID（和配置文件中的worker-id保持一致）
//        snowflakeKeyGenerator.getProps().setProperty("worker-id", "1");
//    }
//
//    /**
//     * 生成雪花ID
//     */
//    public Long generateId() {
//        return (Long) snowflakeKeyGenerator.generateKey();
//    }
//}