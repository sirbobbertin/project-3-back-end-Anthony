package com.project3.revtech.pojo;

public class CartItem {

	private int cartItemId;
	private int cartId;
	private int productId;
	private int cartQty;
	private ProductPojo product;

	public CartItem() {
		super();
	}

	public CartItem(int cartItemId, int cartId, int productId, int cartQty, ProductPojo product) {
		super();
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.cartQty = cartQty;
		this.product = product;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	public ProductPojo getProduct() {
		return product;
	}

	public void setProduct(ProductPojo product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartId=" + cartId + ", productId=" + productId + ", cartQty="
				+ cartQty + ", product=" + product + "]";
	}

}
