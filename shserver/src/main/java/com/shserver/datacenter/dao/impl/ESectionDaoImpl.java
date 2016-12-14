package com.shserver.datacenter.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.shserver.base.utils.Tools;
import com.shserver.datacenter.dao.ESectionDao;
import com.shserver.datacenter.domain.ESection;

@Repository(value = "eSectionDao")
public class ESectionDaoImpl extends SqlSessionDaoSupport implements ESectionDao{

	private static Logger logger = Logger.getLogger(ESectionDaoImpl.class);
	
	private static String ESECTIONMAPPER = "e_section.";
	
	@Override
	public List<ESection> queryByType(String type) {
		logger.info("#####进入查询菜单type:["+type+"]");
		if(Tools.isEmpty(type)){
			return null;
		}
		return this.getSqlSession().selectList(ESECTIONMAPPER+"selectByPType", Integer.valueOf(type));
	}

	@Override
	public ESection queryById(Integer id) {
		if(Tools.isEmpty(id)){
			return null;
		}
		return this.getSqlSession().selectOne(ESECTIONMAPPER+"selectById", Integer.valueOf(id));
	}

	@Override
	public List<ESection> queryList() {
		return this.getSqlSession().selectList(ESECTIONMAPPER+"queryListAll");
	}

	@Override
	public void insert(ESection es) {
		this.getSqlSession().insert(ESECTIONMAPPER+"insert",es);
	}

	@Override
	public void update(ESection es) {
		this.getSqlSession().update(ESECTIONMAPPER+"update",es);
	}
	
	/**
	 * 接口查询
	 * 查询启用的栏目 type -- 1
	 */
	public List<ESection> queryByStatusAndType(String type) {
		logger.info("#####进入查询菜单type:["+type+"]");
		if(Tools.isEmpty(type)){
			return null;
		}
		return this.getSqlSession().selectList(ESECTIONMAPPER+"queryByStatusAndType", Integer.valueOf(type));
	}

}
