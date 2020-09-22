package com.cg.greatoutdoors.dao;

import java.util.List;


import com.cg.greatoutdoors.entity.Cart;



public interface CartDaoInterface {
	
boolean checkId(int userId, int productId);

	
	boolean create(Cart cart);

	Cart getProductInCart(int productId);

	List<Cart> retrieve(int userId);

	boolean deleteProduct(int userId, int productId);



}
