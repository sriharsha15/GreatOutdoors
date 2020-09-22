package com.cg.greatoutdoors.dao;

import com.cg.greatoutdoors.entity.User;

public interface UserDaoInterface {
	User findById(int userId);
}
