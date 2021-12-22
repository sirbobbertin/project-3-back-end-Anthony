package com.project3.revtech.pojo;

import java.sql.Timestamp;

public class Transaction {
	
	private int transactionId;
	private Timestamp transactionDate;
	private int cartId;
	private int cartTotal;
	
	public Transaction() {
		super();
	}

	public Transaction(int transactionId, Timestamp transactionDate, int cartId, int cartTotal) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.cartId = cartId;
		this.cartTotal = cartTotal;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", cartId="
				+ cartId + ", cartTotal=" + cartTotal + "]";
	}

}
