/*
 * package com.pzp.controller;
 * 
 * import java.util.HashMap; import java.util.List; import java.util.Map; import
 * java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.redis.core.ZSetOperations.TypedTuple; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.pzp.service.redis.RedisService;
 * 
 * @RestController
 * 
 * @RequestMapping("/redis") public class RedisController {
 * 
 * @Autowired private RedisService redisService;
 * 
 *//**
	 * 初始化redis
	 */
/*
 * @GetMapping("/init") public void init() { redisService.init(); }
 * 
 *//**
	 * 测试redis设置键值
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
/*
 * @GetMapping("/test/{key}/{value}") public Map<String, String>
 * testRedis(@PathVariable String key, @PathVariable String value) {
 * redisService.setEx(key, value, 600); Map<String, String> result = new
 * HashMap<String, String>(); result.put(key, redisService.get(key)); return
 * result; }
 * 
 *//**
	 * 测试redis获取值
	 * 
	 * @param key
	 * @return
	 */
/*
 * @GetMapping("/{key}") public Map<String, String> getRedisValue(@PathVariable
 * String key) { Map<String, String> result = new HashMap<String, String>();
 * result.put(key, redisService.get(key)); return result; }
 * 
 *//**
	 * 测试redis获取set集合并集
	 * 
	 * @param newKey
	 * @param keys
	 * @return
	 */
/*
 * @GetMapping("/union/{newKey}/{keys}") public Map<String, Set<String>>
 * getRedisSetUnion(@PathVariable String newKey, @RequestBody Set<String> keys)
 * { Map<String, Set<String>> result = new HashMap<String, Set<String>>();
 * result.put(newKey, redisService.sUnion(keys)); return result; }
 * 
 *//**
	 * 测试redis获取set集合差集
	 * 
	 * @param newKey
	 * @param keys
	 * @return
	 */
/*
 * @GetMapping("/diff/{newKey}/{keys}") public Map<String, Set<String>>
 * getRedisSetDiff(@PathVariable String newKey, @RequestBody List<String> keys)
 * { Map<String, Set<String>> result = new HashMap<String, Set<String>>();
 * result.put(newKey, redisService.sDiff(keys)); return result; }
 * 
 *//**
	 * 测试redis获取set集合交集
	 * 
	 * @param newKey
	 * @param keys
	 * @return
	 */
/*
 * @GetMapping("/inter/{newKey}/{keys}") public Map<String, Set<String>>
 * getRedisSetInter(@PathVariable String newKey, @RequestBody Set<String> keys)
 * { Map<String, Set<String>> result = new HashMap<String, Set<String>>();
 * result.put(newKey, redisService.sInter(keys)); return result; }
 * 
 *//**
	 * 测试redis添加zset集合
	 * 
	 * @param key
	 * @param member
	 * @param score
	 * @return
	 */
/*
 * @GetMapping("/zadd/{key}/{member}/{score}") public boolean
 * rediszAdd(@PathVariable String key, @PathVariable String
 * member, @PathVariable("score") double score) { return redisService.zAdd(key,
 * member, score); }
 * 
 *//**
	 * 测试redis计算zset集合数量
	 * 
	 * @param key
	 * @return
	 */
/*
 * @GetMapping("/zcard/{key}") public Long redisCard(@PathVariable String key) {
 * return redisService.zCard(key); }
 * 
 *//**
	 * 测试redis查询zset集合
	 * 
	 * @param key
	 * @param start 开始
	 * @param end   结束
	 * @return
	 */
/*
 * @GetMapping("/zrange/{key}/{start}/{end}") public Map<String, Set<String>>
 * redisRange(@PathVariable String key, @PathVariable long start, @PathVariable
 * long end) { Map<String, Set<String>> result = new HashMap<>();
 * result.put(key, redisService.zRange(key, start, end)); return result; }
 * 
 *//**
	 * 测试redis查询zset集合并附带分值
	 * 
	 * @param key
	 * @param start 开始
	 * @param end   结束
	 * @return
	 *//*
		 * @GetMapping("/zrangewithscore/{key}/{start}/{end}") public Map<String,
		 * Set<TypedTuple<String>>> redisRangeWithScore(@PathVariable String
		 * key, @PathVariable long start, @PathVariable long end) { Map<String,
		 * Set<TypedTuple<String>>> result = new HashMap<>(); result.put(key,
		 * redisService.zRangeWithScores(key, start, end)); return result; }
		 * 
		 * }
		 */