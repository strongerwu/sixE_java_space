package com.shserver.datacenter.dao;

import com.shserver.datacenter.domain.EUsers;

public interface UserDao {

	/**
	 * 登录查询
	 * @param userName
	 * @param password
	 * @return 用户对象
	 */ 
	public EUsers loginQuery(String userName,String password);
	
}
