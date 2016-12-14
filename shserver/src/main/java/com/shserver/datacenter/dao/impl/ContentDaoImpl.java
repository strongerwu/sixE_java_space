package com.shserver.datacenter.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.shserver.datacenter.dao.ContentDao;
import com.shserver.datacenter.domain.EContent;

@Repository(value = "contentDao")
public class ContentDaoImpl extends SqlSessionDaoSupport implements ContentDao{

	private static final String ECONTENTMAPPER = "e_content.";
	
	@Override
	public List<EContent> queryByType(String type) {
		return this.getSqlSession().selectList(ECONTENTMAPPER + "queryByType", Integer.parseInt(type));
	}

	@Override
	public void addOne(EContent e) {
		this.getSqlSession().insert(ECONTENTMAPPER+"insert",e);
		
	}

	@Override
	public void updOne(EContent e) {
		this.getSqlSession().update(ECONTENTMAPPER+"update", e);
		
	}

	@Override
	public EContent queryOne(Integer id) {
		return this.getSqlSession().selectOne(ECONTENTMAPPER+"selectByPrimaryKey", id);
	}
	
	/**
	 * 接口查询
	 * 通过栏目id查询所有启用子栏目
	 */
	public List<EContent> queryBySeType(String type) {
		
		return this.getSqlSession().selectList(ECONTENTMAPPER+"queryBySeType", Integer.valueOf(type));
	}


}
