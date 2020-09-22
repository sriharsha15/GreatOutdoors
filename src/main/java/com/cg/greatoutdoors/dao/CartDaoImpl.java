package com.cg.greatoutdoors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.Cart;

@Repository
public class CartDaoImpl implements CartDaoInterface{

	@PersistenceContext
	EntityManager entityManager;
	
	/**************************************************************************************************
     *Method:checkId
     *description:To check the userId and productId present in database
     
     *@returns                 -boolean
   
     *created by               -Addala Sriharsha
     *created date             -20-Sep-2020
**************************************************************************************************/


	@Override
	public boolean checkId(int userId, int productId) {
	
		String jpql="Select cart.productId from Cart cart  WHERE cart.user.userId=:mid";
		TypedQuery<Integer> query=entityManager.createQuery(jpql, Integer.class);
		query.setParameter("mid", userId);
		List<Integer> productIdList=query.getResultList();
		if(productIdList.contains(productId)) {
			return true;
		}
	
		else {
		return false;
	}
		
	}

	/**************************************************************************************************
     *Method:create
     *description:To add the product to the cart
     
     *@returns                 -boolean
   
     *created by               -Addala Sriharsha
     *created date             -20-Sep-2020
**************************************************************************************************/

	@Override
	public boolean create(Cart cart) {
		entityManager.persist(cart);
		if (entityManager.find(Cart.class, cart.getCartId()) != null) {
			return true;
		} else
			return false;
	}


	/**************************************************************************************************
     *Method:getProductInCart
     *description:To find a particular product already present in the cart
     
     *@returns                 -cart details of a particular product
   
     *created by               -Addala Sriharsha
     *created date             -20-Sep-2020
**************************************************************************************************/

	@Override
	public Cart getProductInCart(int productId) {
		String jpql="from Cart cart  WHERE cart.productId=:mid";
		TypedQuery<Cart> query=entityManager.createQuery(jpql, Cart.class);
		query.setParameter("mid", productId);
		List<Cart> cart=query.getResultList();
		return cart.get(0);
		
	}

	/**************************************************************************************************
     *Method:retrive
     *description:To Retrieve all the products inside the cart of a particular user
     
     *@returns                 -cart details of a particular user
   
     *created by               -Addala Sriharsha
     *created date             -20-Sep-2020
**************************************************************************************************/


	@Override
	public List<Cart> retrieve(int userId) {
		String jpql="from Cart cart  WHERE cart.user.userId=:mid";
		TypedQuery<Cart> query=entityManager.createQuery(jpql, Cart.class);
		query.setParameter("mid", userId);
		List<Cart> cartList=query.getResultList();
		return cartList;
	}


	/**************************************************************************************************
     *Method:retrive
     *description:To remove the a particular product from the cart list
     
     *@returns                 -boolean
   
     *created by               -Addala Sriharsha
     *created date             -20-Sep-2020
**************************************************************************************************/

	
	@Override
	public boolean deleteProduct(int userId, int productId) {
		String productQuery = "FROM Cart cart WHERE  cart.user.userId=:userId  AND cart.productId=:productId";
		TypedQuery<Cart> query3 = entityManager.createQuery(productQuery, Cart.class);
		query3.setParameter("userId", userId);
		query3.setParameter("productId", productId);
		Cart cart = query3.getSingleResult();
		entityManager.remove(cart);
		return true;
	}

	

	

}
