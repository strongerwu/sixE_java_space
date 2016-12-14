package com.shserver.datacenter.dao;

import java.util.List;

import com.shserver.datacenter.domain.EContent;

public interface ContentDao {

	public List<EContent> queryByType(String type);
	
	public void addOne(EContent e);
	
	public void updOne(EContent e);
	
	public EContent queryOne(Integer id);
	
	public List<EContent> queryBySeType(String type);//查询所属栏目下所有启用的子栏目
	
}
