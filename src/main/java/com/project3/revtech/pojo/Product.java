package com.project3.revtech.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;

// PRODUCT, DISCOUNT, & IMAGES
public class Product {

	private int productId;
	private String productSku;
	private String productName;
	private double productCost;
	private String productCategory;
	private String productDescription;
	private int productQty;
	private String imageUrl;
	private boolean productRemoved;
	private int discountId;
	private String discountDescription;
	private BigDecimal discountPercentage;

	private ArrayList<String> images;

	public Product() {
		super();
	}

	public Product(int productId, String productSku, String productName, double productCost, String productCategory,
			String productDescription, int productQty, String imageUrl, boolean productRemoved, int discountId,
			String discountDescription, BigDecimal discountPercentage, ArrayList<String> images) {
		super();
		this.productId = productId;
		this.productSku = productSku;
		this.productName = productName;
		this.productCost = productCost;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productQty = productQty;
		this.imageUrl = imageUrl;
		this.productRemoved = productRemoved;
		this.discountId = discountId;
		this.discountDescription = discountDescription;
		this.discountPercentage = discountPercentage;
		this.images = images;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isProductRemoved() {
		return productRemoved;
	}

	public void setProductRemoved(boolean productRemoved) {
		this.productRemoved = productRemoved;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productSku=" + productSku + ", productName=" + productName
				+ ", productCost=" + productCost + ", productCategory=" + productCategory + ", productDescription="
				+ productDescription + ", productQty=" + productQty + ", imageUrl=" + imageUrl + ", productRemoved="
				+ productRemoved + ", discountId=" + discountId + ", discountDescription=" + discountDescription
				+ ", discountPercentage=" + discountPercentage + ", images=" + images + "]";
	}

}
