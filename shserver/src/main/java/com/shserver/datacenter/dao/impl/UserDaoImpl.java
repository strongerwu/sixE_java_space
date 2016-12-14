package com.shserver.datacenter.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.shserver.datacenter.dao.UserDao;
import com.shserver.datacenter.domain.EUsers;

@Repository(value = "userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	private static final String EUSERSMAPPER = "e_users.";
	
	@Override
	public EUsers loginQuery(String userName, String password) {
		logger.info("#####执行[dao]-【loginQuery】:userName["+userName+"-password["+password+"]");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("password", password);
		return this.getSqlSession().selectOne(EUSERSMAPPER+"loginQuery", map);
	}

}
