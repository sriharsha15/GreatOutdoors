package com.cg.greatoutdoors.dto;

import com.cg.greatoutdoors.entity.Product;

public class CartDetails {

	Product product;
	 //Product quantity added to cart
	int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartDetails(Product product,int quantity) {
		this.product=product;
		this.quantity=quantity;
	}
	
}
