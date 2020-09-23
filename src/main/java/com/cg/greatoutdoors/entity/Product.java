package com.cg.greatoutdoors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Product {
	@Id
	@Column(name="product_Id")
	private int productId;
	
	@Column(name="price",length=5)
	private int price;
	@Column(length=7)
	private String colour;
	
	@Column(name="dimension",length=10)
	private String dimension;
	
	@Column(name="specification",length=15)
	private String specification;
	
	@Column(name="manufacturer",length=10)
	private String manufacturer;
	
	@Column(name="quantity",length=3)
	private int quantity;
	@Column(name="productCategory",length=10)
	private String productCategory;
	
	@Column(name="productName",length=10)
	private String productName;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
}
