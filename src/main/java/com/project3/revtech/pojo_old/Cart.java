package com.project3.revtech.pojo_old;

import java.util.ArrayList;

import com.project3.revtech.entity.CartItem;

public class Cart {

	private int cartId;
	private int userId;
	private int cartTotal;
	private boolean cartPaid;
	private boolean cartRemoved;

	private ArrayList<CartItem> cartItems;

	public Cart() {
		super();
	}

	public Cart(int cartId, int userId, int cartTotal, boolean cartPaid, boolean cartRemoved,
			ArrayList<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.cartTotal = cartTotal;
		this.cartPaid = cartPaid;
		this.cartRemoved = cartRemoved;
		this.cartItems = cartItems;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}

	public boolean isCartPaid() {
		return cartPaid;
	}

	public void setCartPaid(boolean cartPaid) {
		this.cartPaid = cartPaid;
	}

	public boolean isCartRemoved() {
		return cartRemoved;
	}

	public void setCartRemoved(boolean cartRemoved) {
		this.cartRemoved = cartRemoved;
	}

	public ArrayList<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", cartTotal=" + cartTotal + ", cartPaid=" + cartPaid
				+ ", cartRemoved=" + cartRemoved + ", cartItems=" + cartItems + "]";
	}

}
