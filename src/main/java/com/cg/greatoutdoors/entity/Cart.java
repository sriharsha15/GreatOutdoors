package com.cg.greatoutdoors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bk_seq")
	@SequenceGenerator(sequenceName = "bk_seq", allocationSize = 1, name = "bk_seq")
	@Column(name="cart_Id")
	private long cartId;
	
	@Column(name="product_Id",length = 10)
	private int productId;

	@ManyToOne
	@JoinColumn(name = "user_Id",referencedColumnName="user_Id")
	private User user;
	@Column(name="quantity",nullable =false)
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 */
	public Cart(int productId,int quantity) {
		this.productId=productId;
		this.quantity=quantity;
		
		
	}
	public Cart() {
		super();
	}
	
}
