package com.poc.redis.redisdemo;

import java.io.Serializable;

import javax.persistence.Id;

public class TransactionalModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4838704032452047401L;

	private long transactionalId;
	
	@Id
	private long messageId;
	private long paymentId;

	public long getTransactionalId() {
		return transactionalId;
	}

	public void setTransactionalId(long transactionalId) {
		this.transactionalId = transactionalId;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
}
