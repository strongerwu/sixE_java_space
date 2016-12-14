package com.shserver.backstage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shserver.backstage.service.UserService;
import com.shserver.datacenter.dao.UserDao;
import com.shserver.datacenter.domain.EUsers;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public EUsers loginQuery(String userName, String password) {
		return userDao.loginQuery(userName, password);
	}

}
