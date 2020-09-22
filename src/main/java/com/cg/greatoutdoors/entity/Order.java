package com.cg.greatoutdoors.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gorder")
public class Order {
	@Id
	@Column(name="order_Id",length=10)
	private int orderId;
	
	@Column(name="user_Id",nullable=false)
	private int userId;
	
	@Column(name="address_Id",nullable=false)
	private int addressId;
	
	@Column(name="order_Status",nullable=false)
	private byte orderDispatchStatus;
	
	@Column(name="order_Initiate_Time",nullable=false)
	private Date orderInitiateTime;
	
	@Column(name="order_Dispatch_Time")
	private Date orderDispatchTime;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public byte getOrderDispatchStatus() {
		return orderDispatchStatus;
	}

	public void setOrderDispatchStatus(byte orderDispatchStatus) {
		this.orderDispatchStatus = orderDispatchStatus;
	}

	public Date getOrderInitiateTime() {
		return orderInitiateTime;
	}

	public void setOrderInitiateTime(Date orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}

	public Date getOrderDispatchTime() {
		return orderDispatchTime;
	}

	public void setOrderDispatchTime(Date orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}

}
