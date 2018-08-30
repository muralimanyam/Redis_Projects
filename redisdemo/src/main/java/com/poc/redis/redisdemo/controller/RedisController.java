package com.poc.redis.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.redis.redisdemo.entity.PersistanceTransaction;
import com.poc.redis.redisdemo.repository.PersistenceRepository;

@RestController
@CacheConfig(cacheNames = "persistedTransaction")
public class RedisController {

	@Autowired
	private PersistenceRepository mainRepo;

	@RequestMapping(value = "add/transaction", method = RequestMethod.POST)
	@CachePut(keyGenerator = "keyGenerator", cacheNames={"temp", "persistedTransaction"})
	public PersistanceTransaction addTransaction(
			@RequestBody PersistanceTransaction txn) {
		if (txn.getMsg_Id() != null) {
			mainRepo.saveTransaction(txn);
		}
		return txn;
	}

	@RequestMapping(value = "get/transaction/{message_id}", method = RequestMethod.GET)
	@Cacheable(keyGenerator = "keyGenerator", cacheNames={"temp", "persistedTransaction"})
	public PersistanceTransaction getTransaction(
			@PathVariable("message_id") String messageId) {
		return mainRepo.findTxnByMsgId(messageId);
	}

	@RequestMapping("delete/transaction/{message_id}")
	@CacheEvict(keyGenerator = "keyGenerator")
	public PersistanceTransaction deleteTransaction(
			@PathVariable("message_id") String messageId) {
		PersistanceTransaction txn = mainRepo.findTxnByMsgId(messageId);
		if (txn != null) {
			mainRepo.deleteTransactionByMsgId(messageId);
		}
		return txn;
	}
}
