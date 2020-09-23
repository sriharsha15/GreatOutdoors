package com.cg.greatoutdoors.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.CartDaoInterface;
import com.cg.greatoutdoors.dto.CartDetails;
import com.cg.greatoutdoors.entity.Cart;
import com.cg.greatoutdoors.entity.Product;
import com.cg.greatoutdoors.entity.User;
import com.cg.greatoutdoors.exception.AddToCartException;
import com.cg.greatoutdoors.exception.ProductException;
import com.cg.greatoutdoors.exception.UserException;


@Service
@Transactional
public class CartServiceImpl implements CartServiceInterface {
	@Autowired
	private CartDaoInterface cartDao;
	@Autowired
	private UserServiceInterface userService;
	@Autowired
	private ProductServiceInterface productService;
	
	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that check the userId , productId and if the product already present in cart
	*       version           1.0
	*       created date      21-sep-2020
	 * @throws AddToCartException 
	 * @throws ProductException ,UserException
	
	********************************************************************************************************************/
	

	@Override
	public boolean checkId(int userId, int productId) throws ProductException,UserException, AddToCartException {
	
			User result=userService.findUserId(userId);
			
		 if(result!=null) {
			
			Product checkProduct=productService.findProductId(productId);
			if(checkProduct!=null)
			{
				boolean checkCart=cartDao.checkId(userId, productId);
				if(checkCart) {
					return true;
				}
				else {
					return false;
				}
			}
					

		}
		return false;
//	Optional<User>status =userjpadao.findById(userId);
//	if(status.isPresent()== true) {
//		Optional<Product> productStatus =productjpadao.findById(productId);
//		if(productStatus.isPresent()==true) {
//			return true;
//		}
//		else
//			return false;
//			
//	}
//	else
//		return false;
	}

	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that adds the product to the cart
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws ProductException ,UserException, AddToCartException
	
	********************************************************************************************************************/
	
	@Override
	public boolean addToCart(Cart cart) throws ProductException, AddToCartException,UserException {
		if(!(checkId(cart.getUser().getUserId(),cart.getProductId()))) {
			Product product=productService.findProductId(cart.getProductId());
			int beforeUpdate=product.getQuantity();
			if(cart.getQuantity()<=0) {
				throw new AddToCartException("Quantity to be added cannot be less than or equal to zero");
			}
			else if (beforeUpdate<cart.getQuantity()) {
				throw new AddToCartException("Sorry,Only "+beforeUpdate+" are left in stock");
				
			}
			else {
			int afterUpdate=beforeUpdate-cart.getQuantity();
			product.setQuantity(afterUpdate);
		boolean status=cartDao.create(cart);
		if(status)
		{
			//updateProductQuantity(cart);
			return true;
		}
		else
		{
			throw new ProductException("Unable to insert in cart");
		}
			}
		}
		else {
			throw new AddToCartException("Product already in cart");
		}
			
	}
	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that update the product quantity in product table 
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws ProductException ,AddToCartException
	
	********************************************************************************************************************/
	

	/*private void updateProductQuantity(Cart cart) throws ProductException, AddToCartException {
		Product product=productService.findProductId(cart.getProductId());
		int beforeUpdate=product.getQuantity();
		if(cart.getQuantity()<=0) {
			throw new AddToCartException("Quantity to be added cannot be less than or equal to zero");
		}
		else if (beforeUpdate<cart.getQuantity()) {
			throw new AddToCartException("Sorry,Only "+beforeUpdate+" are left in stock");
			
		}
		else {
		int afterUpdate=beforeUpdate-cart.getQuantity();
		product.setQuantity(afterUpdate);
		

		}
		
	}*/

	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that update the product already inside a cart 
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws ProductException , AddToCartException
	
	********************************************************************************************************************/
	
	@Override
	public boolean updateCartProduct(int productId,int quantity) throws AddToCartException, ProductException {
		
		Cart cart=cartDao.getProductInCart(productId);
		if(cart==null)
		{
			throw new AddToCartException("Product Not Found In Cart");
		}
		else {
			Product product=productService.findProductId(cart.getProductId());
		int beforeUpdate=product.getQuantity();
		if(quantity<=0) {
			throw new AddToCartException("Quantity to be added cannot be less than or equal to zero");
		}
else if (quantity<cart.getQuantity()) {
	
			int quantityReduced=cart.getQuantity()-quantity;
			int afterUpdate=beforeUpdate+quantityReduced;
			product.setQuantity(afterUpdate);
			cart.setQuantity(quantity);
			return true;
		}
else if (quantity==cart.getQuantity()) {
	return true;
	
}
		else {
			int quantityIncreased=quantity-cart.getQuantity();
			
		int afterUpdate=beforeUpdate-quantityIncreased;
		if(afterUpdate<0) {
			throw new ProductException("Sorry,Only "+beforeUpdate+" are left in stock");
		}else {
		product.setQuantity(afterUpdate);
		cart.setQuantity(quantity);
		
		return true;
		}
		}
			
		}
		
		
	}
	
	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that removes the product from the cart
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws ProductException , UserException
	
	********************************************************************************************************************/
	
	@Override
	public boolean removeProduct(int userId, int productId) throws ProductException, UserException {
		User result=userService.findUserId(userId);
		
		 if(result!=null) {
			
			Product checkProduct=productService.findProductId(productId);
			if(checkProduct!=null)
			{
				boolean checkCart=cartDao.checkId(userId, productId);
				if(checkCart) {
					Cart cart=cartDao.getProductInCart(productId);
					int quantity=checkProduct.getQuantity();
					checkProduct.setQuantity(cart.getQuantity()+quantity);
					 boolean status=cartDao.deleteProduct(userId, productId);
					 if(status)
					 {
						 return true;
					 }
					 else {
						 throw new ProductException("Not able to remove the product");
					 }
				}
				else {
					throw new ProductException("Product Not In Cart");
				}
			}
					

		}
		return false;
		
	}
	
	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that retrieves from the cart
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws ProductException , UserException
	
	********************************************************************************************************************/
	

	@Override
	public List<CartDetails> retrive(int userId) throws ProductException, UserException {
		User result=userService.findUserId(userId);
		
		 if(result!=null) {
		List<Cart> cartList = cartDao.retrieve(userId);
		List<CartDetails> productDetails=new ArrayList<CartDetails>();
		for(Cart cart:cartList) {
			Product product=productService.findProductId(cart.getProductId());
			CartDetails details=new CartDetails(product,cart.getQuantity());
			productDetails.add(details);
		}
	if(cartList.isEmpty()) {
		throw new ProductException("List is empty");
	}
	else {
		return productDetails;
	}
		 
	}
	
	else {
		
	}
		return null;
	}
	

	

	

	
}
