package com.cg.greatoutdoors.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.Product;


@Repository
public class ProductDaoImpl implements ProductDaoInterface {
	@PersistenceContext
	EntityManager entityManager;
		

	/**************************************************************************************************
	 *Method:findById
	 *description:To find a particular product from the product table
	 
	 *@returns                 -product details of a particular productId

	 *created by               -Addala Sriharsha
	 *created date             -20-AUG-2020
	**************************************************************************************************/

		@Override
		public Product findById(int productId) {
			Product product=entityManager.find(Product.class, productId);
			return product;
		}

}
