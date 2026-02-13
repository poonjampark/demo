/*
 * package com.pzp.service.redis;
 * 
 * import java.util.Collections; import java.util.List; import java.util.Map;
 * import java.util.Set; import java.util.concurrent.TimeUnit;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.redis.connection.DataType; import
 * org.springframework.data.redis.core.HashOperations; import
 * org.springframework.data.redis.core.ListOperations; import
 * org.springframework.data.redis.core.SetOperations; import
 * org.springframework.data.redis.core.StringRedisTemplate; import
 * org.springframework.data.redis.core.ValueOperations; import
 * org.springframework.data.redis.core.ZSetOperations; import
 * org.springframework.data.redis.core.ZSetOperations.TypedTuple; import
 * org.springframework.data.redis.core.script.DefaultRedisScript; import
 * org.springframework.stereotype.Repository;
 * 
 * @Repository public class RedisService {
 * 
 * @Autowired private StringRedisTemplate redisTemplate;
 * 
 * private ValueOperations<String, String> stringOps; private
 * HashOperations<String, Object, Object> hashOps; private
 * ListOperations<String, String> listOps; private SetOperations<String, String>
 * setOps; private ZSetOperations<String, String> zsetOps;
 * 
 * public void init() { stringOps = redisTemplate.opsForValue(); hashOps =
 * redisTemplate.opsForHash(); listOps = redisTemplate.opsForList(); setOps =
 * redisTemplate.opsForSet(); zsetOps = redisTemplate.opsForZSet(); }
 * 
 *//**
	 * 设置值
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
/*
 * public void set(String key, String value) { stringOps.set(key, value); }
 * 
 *//**
	 * 设置值并附加过期时间,单位：秒
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
/*
 * public void setEx(String key, String value, int time) { stringOps.set(key,
 * value, time, TimeUnit.SECONDS); }
 * 
 *//**
	 * 当键不存在时设置值并附加过期时间,单位：秒 分布式锁，尝试获取锁
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
/*
 * public boolean tryLock(String key, String value, int time) { boolean flag =
 * stringOps.setIfAbsent(key, value, time, TimeUnit.SECONDS); return flag; }
 * 
 *//**
	 * 分布式锁，释放锁
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
/*
 * public void unLock(String lockKey, String lockValue) { String script =
 * "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end"
 * ; redisTemplate.execute(new DefaultRedisScript<>(script, Long.class),
 * Collections.singletonList(lockKey), lockValue); }
 * 
 *//**
	 * 批量设值
	 * 
	 * @param map
	 */
/*
 * public void mSet(Map<String, String> map) { stringOps.multiSet(map); }
 * 
 *//**
	 * 普通根据键获取值
	 * 
	 * @param key
	 * @return
	 */
/*
 * public String get(String key) { return stringOps.get(key); }
 * 
 *//**
	 * hash设值
	 * 
	 * @param key
	 * @param valueKey
	 * @param value
	 */
/*
 * public void hSet(String key, Object valueKey, Object value) {
 * hashOps.put(key, valueKey, value); }
 * 
 *//**
	 * hash根据键获取值
	 * 
	 * @param key
	 */
/*
 * public Object hGet(String key, Object valueKey) { return hashOps.get(key,
 * valueKey); }
 * 
 *//**
	 * hash获取所有的键
	 * 
	 * @param key
	 */
/*
 * public Set<Object> keys(String key) { return hashOps.keys(key); }
 * 
 *//**
	 * hash获取所有的值
	 * 
	 * @param key
	 */
/*
 * public List<Object> values(String key) { return hashOps.values(key); }
 * 
 *//**
	 * hash获取所有的键值
	 * 
	 * @param key
	 */
/*
 * public Map<Object, Object> hGetAll(String key) { return hashOps.entries(key);
 * }
 * 
 *//**
	 * hash让某个键的值增减或者减少
	 * 
	 * @param key
	 * @param valueKey
	 * @param num      正数是增加，负数是减少
	 * @return
	 */
/*
 * public Long hIncrBy(String key, String valueKey, long num) { return
 * hashOps.increment(key, valueKey, num); }
 * 
 *//**
	 * 列表将一个或多个值插入到头部
	 * 
	 * @param key
	 * @param values
	 * @return
	 */
/*
 * public Long lPush(String key, List<String> values) { return
 * listOps.leftPushAll(key, values); }
 * 
 *//**
	 * 列表将一个或多个值插入到尾部
	 * 
	 * @param key
	 * @param values
	 * @return
	 */
/*
 * public Long rPush(String key, List<String> values) { return
 * listOps.rightPushAll(key, values); }
 * 
 *//**
	 * 列表返回并移除第一个元素
	 * 
	 * @param key
	 * @param values
	 * @return
	 */
/*
 * public String lPop(String key) { return listOps.leftPop(key); }
 * 
 *//**
	 * 列表返回并移除最后一个元素
	 * 
	 * @param key
	 * @param values
	 * @return
	 */
/*
 * public String rPop(String key) { return listOps.rightPop(key); }
 * 
 *//**
	 * set向集合添加一个成员
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
/*
 * public Long sAdd(String key, String value) { return setOps.add(key, value); }
 * 
 *//**
	 * set集合移除一个成员
	 * 
	 * @param key
	 * @param values
	 * @return
	 */
/*
 * public Long sRem(String key, String value) { return setOps.remove(key,
 * value); }
 * 
 *//**
	 * 判断一个键是否在set集合中
	 * 
	 * @param key
	 * @param values
	 * @return
	 */
/*
 * public Boolean sIsMember(String key, String value) { return
 * setOps.isMember(key, value); }
 * 
 *//**
	 * 求多个set集合中的并集
	 * 
	 * @param keys
	 * @return
	 */
/*
 * public Set<String> sUnion(Set<String> keys) { return setOps.union(keys); }
 * 
 *//**
	 * 求多个set集合中的交集
	 * 
	 * @param keys
	 * @return
	 */
/*
 * public Set<String> sInter(Set<String> keys) { return setOps.intersect(keys);
 * }
 * 
 *//**
	 * 求多个set集合中的差集，第一个为准，并存到目标集合中
	 * 
	 * @param keys
	 * @return
	 */
/*
 * public Set<String> sDiff(List<String> keys) { return setOps.difference(keys);
 * }
 * 
 *//**
	 * zset集合添加一个成员和分值
	 * 
	 * @param key
	 * @param member
	 * @param score
	 * @return
	 */
/*
 * public Boolean zAdd(String key, String member, double score) { return
 * zsetOps.add(key, member, score); }
 * 
 *//**
	 * zset集合计算所有成员数量
	 * 
	 * @param key
	 * @param valueKey
	 * @param score
	 * @return
	 */
/*
 * public Long zCard(String key) { return zsetOps.size(key); }
 * 
 *//**
	 * zset集合查询一定范围内的数据
	 * 
	 * @param key
	 * @param start 开始
	 * @param end   结束
	 * @return
	 */
/*
 * public Set<String> zRange(String key, long start, long end) { return
 * zsetOps.range(key, start, end); }
 * 
 *//**
	 * zset集合查询一定范围内的数据并返回分值
	 * 
	 * @param key
	 * @param valueKey
	 * @param score
	 * @return
	 */
/*
 * public Set<TypedTuple<String>> zRangeWithScores(String key, long start, long
 * end) { return zsetOps.rangeWithScores(key, start, end); }
 * 
 *//**
	 * 删除某个键
	 * 
	 * @param key
	 * @return
	 */
/*
 * public boolean del(String key) { return redisTemplate.delete(key); }
 * 
 *//**
	 * 批量删除键
	 * 
	 * @param key
	 * @return
	 */
/*
 * public long del(List<String> keys) { return redisTemplate.delete(keys); }
 * 
 *//**
	 * 检查键是否存在
	 * 
	 * @param key
	 * @return
	 */
/*
 * public boolean exists(String key) { return redisTemplate.hasKey(key); }
 * 
 *//**
	 * 查看键剩余过期时间（秒） -1：永不过期；-2：键不存在
	 * 
	 * @param key
	 * @return
	 */
/*
 * public long ttl(String key) { return redisTemplate.getExpire(key); }
 * 
 *//**
	 * 获取键值数据类型 返回 string, hash, list 等
	 * 
	 * @param key
	 * @return
	 *//*
		 * public DataType type(String key) { return redisTemplate.type(key); }
		 * 
		 * }
		 */