package com.pzp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.pzp.mapper") // 将项目中对应的mapper类的路径加进来就可以了
//@EnableWebSecurity
//@EnableScheduling
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
@SpringBootApplication
public class DemoApplication {
	
//	@Autowired
//	private RedisTemplate redisTemplate= null;
	
//	@PostConstruct
//	public void init() {
//		initRedisTemplate();
//	}
	
//	private void initRedisTemplate() {
//		RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
//		redisTemplate.setKeySerializer(stringSerializer);
//		redisTemplate.setHashKeySerializer(stringSerializer);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
