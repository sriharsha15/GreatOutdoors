package com.cg.greatoutdoors.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.UserDaoInterface;
import com.cg.greatoutdoors.entity.User;
import com.cg.greatoutdoors.exception.UserException;




@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	UserDaoInterface userDao;
	public void abc(CartServiceInterface cart) {
		
	}
	
	/********************************************************************************************************************
	*       @author           Addala Sriharsha
	*       Description       It is a service that finds the user from the user table
	*       version           1.0
	*       created date      21-Sep-2020
	 * @throws UserException
	
	********************************************************************************************************************/
	
	@Override
	public User findUserId(int userId) throws UserException {
		User user = userDao.findById(userId);
		if (user == null) {
			throw new UserException("User Not Found");
		} else {
			return user;
		}
	}
}
