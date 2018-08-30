package com.poc.redis.redisdemo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_persisting_trans")
public class PersistanceTransaction implements Serializable{

	/**
	 * Generated version ID.
	 */
	private static final long serialVersionUID = 4986799363085366457L;

	@Id
	@Column
	private String msg_Id;

	@Column
	private String trx_Id;

	@Column
	private Timestamp credit_date_time;

	@Column
	private String bsb;

	@Column
	private float sum_amt;

	@Column
	private String branch_id;

	@Column
	private float stlmnt_amt;

	@Column
	private String debtor_name;

	@Column
	private String creditor_name;

	@Column
	private String currency;

	@Column
	private String request_obj;

	@Column
	private Long creditor_acc;

	@Column
	private Long debtor_acc;

	public Long getCreditor_acc() {
		return creditor_acc;
	}

	public void setCreditor_acc(Long creditor_acc) {
		this.creditor_acc = creditor_acc;
	}

	public Long getDebtor_acc() {
		return debtor_acc;
	}

	public void setDebtor_acc(Long debtor_acc) {
		this.debtor_acc = debtor_acc;
	}

	public String getMsg_Id() {
		return msg_Id;
	}

	public void setMsg_Id(String msg_Id) {
		this.msg_Id = msg_Id;
	}

	public String getTrx_Id() {
		return trx_Id;
	}

	public void setTrx_Id(String trx_Id) {
		this.trx_Id = trx_Id;
	}

	public Timestamp getCreditDateTime() {
		return credit_date_time;
	}

	public void setCreditDateTime(Timestamp creditDateTime) {
		this.credit_date_time = creditDateTime;
	}

	public String getBsb() {
		return bsb;
	}

	public void setBsb(String bsb) {
		this.bsb = bsb;
	}

	public float getSum_amt() {
		return sum_amt;
	}

	public void setSum_amt(float sum_amt) {
		this.sum_amt = sum_amt;
	}

	public String getBranchId() {
		return branch_id;
	}

	public void setBranchId(String branchId) {
		this.branch_id = branchId;
	}

	public float getStlmntAmt() {
		return stlmnt_amt;
	}

	public void setStlmntAmt(float stlmntAmt) {
		this.stlmnt_amt = stlmntAmt;
	}

	public String getDebtor_name() {
		return debtor_name;
	}

	public void setDebtor_name(String debtor_name) {
		this.debtor_name = debtor_name;
	}

	public String getCreditor_name() {
		return creditor_name;
	}

	public void setCreditor_name(String creditor_name) {
		this.creditor_name = creditor_name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRequest_obj() {
		return request_obj;
	}

	public void setRequest_obj(String request_obj) {
		this.request_obj = request_obj;
	}
}
