package com.cg.greatooutdoors.controller;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.greatoutdoors.service.CartServiceInterface;
import com.cg.greatoutdoors.service.ProductServiceInterface;
import com.cg.greatoutdoors.service.UserServiceInterface;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GreatOudoorsControllerTesta {

	@Autowired
	CartServiceInterface cartService;
	@Autowired
	ProductServiceInterface productService;
	@Autowired 
	UserServiceInterface userService;
	
	
}
