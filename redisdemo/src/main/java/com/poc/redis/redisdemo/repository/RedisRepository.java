package com.poc.redis.redisdemo.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.poc.redis.redisdemo.entity.PersistanceTransaction;

@Repository
public class RedisRepository {

	@Autowired
	private RedisTemplate<String, PersistanceTransaction> redisTemplate;

	private HashOperations<String, String, Object> hashOperations;

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	public void addEntry(String val) {
		hashOperations.put("key2", "IdOrKey", val);
	}
	
	public void deleteEntry(String key){
		hashOperations.delete(key, new Object[]{"IdOrKey"});
	}
}
