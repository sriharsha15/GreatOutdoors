package com.cg.greatoutdoors.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.User;


@Repository
public class UserDaoImpl implements UserDaoInterface {
	@PersistenceContext
	EntityManager entityManager;


	/**************************************************************************************************
     *Method:findById
     *description:To find a paticular user from the user table
     
     *@returns                 -user details of a particular userId
   
     *created by               -Addala Sriharsha
     *created date             -20-Sep-2020
**************************************************************************************************/

	@Override
	public User findById(int userId) {
		User user=entityManager.find(User.class, userId);
		
        return user;
	}
}
