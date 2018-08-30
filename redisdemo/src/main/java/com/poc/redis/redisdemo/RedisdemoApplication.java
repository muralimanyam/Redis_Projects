package com.poc.redis.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.poc.redis.redisdemo.repository.RedisRepository;

@SpringBootApplication
@EnableCaching
public class RedisdemoApplication implements CommandLineRunner{
	
	@Autowired
	private RedisRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RedisdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("RedisdemoApplication.run() : Running the Demo app." );
//		repository.addEntry("Test input");
		
//		repository.deleteEntry("key2");
	}
}
