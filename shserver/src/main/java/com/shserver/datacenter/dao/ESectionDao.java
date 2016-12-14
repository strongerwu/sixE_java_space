package com.shserver.datacenter.dao;

import java.util.List;

import com.shserver.datacenter.domain.ESection;

public interface ESectionDao {
	/**
	 * 查询ESection
	 * @param type
	 * @return
	 */
	public List<ESection> queryByType(String type);
	
	public List<ESection> queryList();
	
	public ESection queryById(Integer id);
	
	public void insert(ESection es);
	
	public void update(ESection es);

	public List<ESection> queryByStatusAndType(String type);
	
}
