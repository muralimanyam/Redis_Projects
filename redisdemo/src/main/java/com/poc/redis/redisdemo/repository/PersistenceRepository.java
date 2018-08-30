package com.poc.redis.redisdemo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poc.redis.redisdemo.entity.PersistanceTransaction;

@Repository
public class PersistenceRepository {

	@Autowired
	private EntityManager em;

	public PersistanceTransaction findTxnByMsgId(String messageId) {
		System.out.println("PersistenceRepository.findTxnByMsgId() : " + messageId);
		return em.find(PersistanceTransaction.class, messageId);
	}

	@Transactional
	public void saveTransaction(PersistanceTransaction txn) {
		PersistanceTransaction retrievedTxn = findTxnByMsgId(txn.getMsg_Id());
		if (retrievedTxn == null) {
			em.persist(txn);
		} else {
			em.merge(txn);
		}
	}

	@Transactional
	public void deleteTransactionByMsgId(String messageId) {
		PersistanceTransaction retrievedTxn = findTxnByMsgId(messageId);
		if (retrievedTxn != null) {
			em.remove(retrievedTxn);
		}
	}
}
