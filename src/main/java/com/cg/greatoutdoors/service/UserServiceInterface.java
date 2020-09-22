package com.cg.greatoutdoors.service;

import com.cg.greatoutdoors.entity.User;
import com.cg.greatoutdoors.exception.UserException;

public interface UserServiceInterface
{
	User findUserId(int userId) throws UserException;
}
