package com.cg.greatoutdoors.service;

import com.cg.greatoutdoors.entity.Product;
import com.cg.greatoutdoors.exception.ProductException;

public interface ProductServiceInterface {

	Product findProductId(int productId) throws ProductException;
}
