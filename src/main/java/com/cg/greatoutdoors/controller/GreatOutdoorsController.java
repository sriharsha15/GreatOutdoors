package com.cg.greatoutdoors.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.greatoutdoors.GreatOutdoorsApplication;
import com.cg.greatoutdoors.dto.CartDetails;
import com.cg.greatoutdoors.dto.ProductDetails;
import com.cg.greatoutdoors.entity.Cart;
import com.cg.greatoutdoors.exception.AddToCartException;
import com.cg.greatoutdoors.exception.ProductException;
import com.cg.greatoutdoors.exception.UserException;
import com.cg.greatoutdoors.service.CartServiceInterface;
import com.cg.greatoutdoors.service.ProductServiceInterface;
import com.cg.greatoutdoors.service.UserServiceInterface;

@RestController
public class GreatOutdoorsController {
	@Autowired
	CartServiceInterface cartService;
	@Autowired
	ProductServiceInterface productService;
	@Autowired 
	UserServiceInterface userService;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GreatOutdoorsApplication.class);
	String msg;
	
	//Https request for adding a product to cart 
	@PostMapping("/addToCart/{userId}")
	public ResponseEntity<String> addToCart(@PathVariable("userId") int userId,@RequestBody ProductDetails  product) throws ProductException, UserException, AddToCartException
	   {   
		    if(!cartService.checkId(userId,product.getProductId()))
		    {
		    	Cart cart=new Cart(product.getProductId(),product.getQuantity());
		    	cart.setUser(userService.findUserId(userId));
		    	
		    	boolean result=cartService.addToCart(cart);
		    	msg="Product successfully added to cart";
		    	LOGGER.info(msg);
		    	return new ResponseEntity<String>("Successfully added", HttpStatus.OK);
		    }  
		    else {
		    	return new ResponseEntity<String>("Product already in cart", HttpStatus.OK);
		    }
			
		    
	   }
	
	//Https request to edit the product quantity added to cart 
	@PutMapping("/editCart/{userId}")
	public ResponseEntity<String> editCart(@PathVariable("userId") int userId,@RequestBody ProductDetails  product) throws ProductException, UserException, AddToCartException
	{
		boolean result=cartService.checkId(userId,product.getProductId());
		if(result) {
			cartService.updateCartProduct(product.getProductId(),product.getQuantity());
			msg="Product in cart is updated";
	    	LOGGER.info(msg);
	    	return new ResponseEntity<String>("Successfully updated", HttpStatus.OK);

		}
		else {
			return new ResponseEntity<String>("Product not found in cart", HttpStatus.OK);
			}
		}
	
	//Https request to delete the product from cart
	@DeleteMapping("/removeFromCart/{userId}/{productId}")
	   public ResponseEntity<String> deleteProduct(@PathVariable("userId") int userId,@PathVariable("productId") int productId) throws ProductException, UserException
	   {   
		   boolean result=cartService.removeProduct(userId, productId);
		   if(result) {
			   msg="deleted successfully";
			   LOGGER.info(msg);
		    	return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);

		   }
		return null;
		 
	   }
	
	//Https request to retrieve from the cart
	@GetMapping("/cartList/{userId}")
	public ResponseEntity<List<CartDetails>> fetchProduct(@PathVariable("userId") int userId) throws ProductException, UserException
	{  
	    List<CartDetails> cartDetails=cartService.retrive(userId);
	    msg="Products in the cart"+cartDetails;
	    LOGGER.info(msg);
	    return new ResponseEntity<List<CartDetails>>(cartDetails,HttpStatus.OK);
	}
  
	
	
}
