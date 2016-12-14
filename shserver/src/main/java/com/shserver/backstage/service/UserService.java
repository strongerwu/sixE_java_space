package com.shserver.backstage.service;

import com.shserver.datacenter.domain.EUsers;

public interface UserService {
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public EUsers loginQuery(String userName,String password);
	
}
