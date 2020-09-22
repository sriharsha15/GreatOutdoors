package com.cg.greatoutdoors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Whishlist {
	@Id
	@Column(name="whishlist_Id")
	private int whishlistId;
	
	@Column(name="product_Id",length = 10)
	private long productId;

	@ManyToOne
	@JoinColumn(name = "user_Id",referencedColumnName="user_Id")
	private User user;

	

	public int getWhishlistId() {
		return whishlistId;
	}

	public void setWhishlistId(int whishlistId) {
		this.whishlistId = whishlistId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
