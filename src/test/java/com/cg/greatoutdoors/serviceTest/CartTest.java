package com.cg.greatoutdoors.serviceTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.greatoutdoors.entity.Cart;
import com.cg.greatoutdoors.exception.AddToCartException;
import com.cg.greatoutdoors.exception.ProductException;
import com.cg.greatoutdoors.exception.UserException;
import com.cg.greatoutdoors.service.CartServiceInterface;
import com.cg.greatoutdoors.service.UserServiceInterface;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional

public class CartTest {
	@Autowired
	private CartServiceInterface cartService;
	@Autowired
	UserServiceInterface userService;
	
	

	@Test
	@DisplayName("Test for checking an user and  product in cart")
	public void checkIdTest() throws UserException,ProductException, AddToCartException
	{
		Throwable expection=assertThrows(UserException.class,()->{cartService.checkId(100,100);});
		assertEquals("User Not Found",expection.getMessage());
		Throwable expection1=assertThrows(ProductException.class,()->{cartService.checkId(101,100);});
		assertEquals("Product Not Found",expection1.getMessage());
		assertTrue(cartService.checkId(101,106));
		//assertFalse(cartService.checkId(101,106));

		
		
	}
	@Test
	@DisplayName("Test for adding an product in cart")
	public void addToCartTest() throws UserException, ProductException, AddToCartException
	{
		Cart cart=new Cart(106,4);
		cart.setUser(userService.findUserId(102));
		assertEquals(true,cartService.addToCart(cart));
		Throwable expection1=assertThrows(AddToCartException.class,()->{cartService.addToCart(cart);});
		assertEquals("Product already in cart",expection1.getMessage());
	}
	
	@Test
	@DisplayName("Test for updating the product in cart")
	public void updateCartTest() throws UserException, ProductException, AddToCartException {
		Cart cart=new Cart(107,4);
		cart.setUser(userService.findUserId(101));
		assertEquals(true,cartService.addToCart(cart));
		Throwable expection=assertThrows(AddToCartException.class,()->{cartService.updateCartProduct(107,-8);});
		assertEquals("Quantity to be added cannot be less than or equal to zero",expection.getMessage());
		
	}
	
	@Test
	public void updateQuantityTest() throws UserException {
		Cart cart=new Cart(106,0);
		cart.setUser(userService.findUserId(2));
		Throwable expection=assertThrows(AddToCartException.class,()->{cartService.addToCart(cart);});
		assertEquals("Quantity to be added cannot be less than or equal to zero",expection.getMessage());
		
		
		
		
	}
	
	@Test
	public void removeTest() throws UserException, ProductException, AddToCartException {
		Throwable expection=assertThrows(ProductException.class,()->{cartService.removeProduct(101,106);});
		assertEquals("Product Not In Cart",expection.getMessage());
		Cart cart=new Cart(106,4);
		cart.setUser(userService.findUserId(101));
		cartService.addToCart(cart);
		assertEquals(true,cartService.removeProduct(101,106));

		
		
	}
	
	



}
