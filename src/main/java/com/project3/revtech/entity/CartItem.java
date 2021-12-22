package com.project3.revtech.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cart_items")
public class CartItem {
	
	@Id
	@Column(name = "cart_item_id")
	private int cartItemId;
	
	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "product_id")
	private int productId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = false, insertable = false, updatable = false)
	private Cart cart;

	@Column(name = "cart_qty")
	private int cartQty;

	public CartItem(int cartItemId, int cartId, int productId, Product product, Cart cart, int cartQty) {
		super();
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.product = product;
		this.cart = cart;
		this.cartQty = cartQty;
	}

}