package com.poc.redis.redisdemo.config;

import java.lang.reflect.Method;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.poc.redis.redisdemo.entity.PersistanceTransaction;

@Configuration
public class RedisConfig {
	@Autowired
	private RedisConfigSerializer cfgSer;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, PersistanceTransaction> redisTemplate() {
		final RedisTemplate<String, PersistanceTransaction> template = new RedisTemplate<String, PersistanceTransaction>();
		template.setConnectionFactory(jedisConnectionFactory());
		/*
		 * template.setValueSerializer(new GenericToStringSerializer<Object>(
		 * Object.class));
		 */

		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(cfgSer);
		return template;
	}

	private static final long EXPIRATION_IN_SECONDS = 300;

	@Bean
	public CacheManager redisCacheManager() {
		Duration expiration = Duration.ofSeconds(EXPIRATION_IN_SECONDS);
		return RedisCacheManager
				.builder(jedisConnectionFactory())
				.cacheDefaults(
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(
								expiration)).build();
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {

			@Override
			public Object generate(Object arg0, Method arg1, Object... arg2) {
				String key = "";
				for (Object ob : arg2) {
					if (ob instanceof PersistanceTransaction) {
						key = ((PersistanceTransaction) ob).getMsg_Id();
					}
				}
				return key;
			}
		};
	}
}
