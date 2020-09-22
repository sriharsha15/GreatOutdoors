package com.cg.greatoutdoors.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.ProductDaoInterface;
import com.cg.greatoutdoors.entity.Product;
import com.cg.greatoutdoors.exception.ProductException;


@Service
@Transactional
public class ProductServiceImpl implements ProductServiceInterface{

	@Autowired
	private ProductDaoInterface productDao;
		

	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that finds the product from the product table
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws ProductException 

	********************************************************************************************************************/

		@Override
		public Product findProductId(int productId) throws ProductException {
			Product product = productDao.findById(productId);
			if (product == null) {
				throw new ProductException("Product Not Found");
			} else {
				return product;
			}
		}
}
