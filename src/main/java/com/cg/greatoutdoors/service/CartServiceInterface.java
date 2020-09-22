package com.cg.greatoutdoors.service;

import java.util.List;

import com.cg.greatoutdoors.dto.CartDetails;
import com.cg.greatoutdoors.entity.Cart;
import com.cg.greatoutdoors.exception.AddToCartException;
import com.cg.greatoutdoors.exception.ProductException;
import com.cg.greatoutdoors.exception.UserException;



public interface CartServiceInterface {
	public boolean checkId(int userId, int productId) throws ProductException, UserException, AddToCartException;

	public boolean addToCart(Cart cart) throws ProductException, AddToCartException, UserException;

	public boolean updateCartProduct(int productId,int quantity) throws AddToCartException, ProductException;

	public boolean removeProduct(int  userId, int  productId) throws ProductException, UserException;

	public List<CartDetails> retrive(int userId) throws ProductException, UserException;



}
