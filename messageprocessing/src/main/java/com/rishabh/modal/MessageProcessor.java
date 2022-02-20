package com.rishabh.modal;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MessageProcessor {

	@Id
	private UUID transactionId;	
	private int clientId;
	private String transactionType;
	private Date transactionDate;
	private double notional;
	private String sourceSystem;
	private char priorityFlag;
	

	
	public MessageProcessor(UUID transactionId, int clientId, String transactionType, Date transactionDate,
			double notional, String sourceSystem, char priorityFlag) {
		super();
		this.transactionId = transactionId;
		this.clientId = clientId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.notional = notional;
		this.sourceSystem = sourceSystem;
		this.priorityFlag = priorityFlag;
	}
	public MessageProcessor() {
		super();
	}
	public UUID getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(UUID uuid) {
		this.transactionId = uuid;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getNotional() {
		return notional;
	}
	public void setNotional(double notional) {
		this.notional = notional;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public char getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(char priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	@Override
	public String toString() {
		return "MessageProcessor [transactionId=" + transactionId + ", clientId=" + clientId + ", transactionType="
				+ transactionType + ", transactionDate=" + transactionDate + ", notional=" + notional
				+ ", sourceSystem=" + sourceSystem + ", priorityFlag=" + priorityFlag + "]";
	}
	
	
	
	 
}
