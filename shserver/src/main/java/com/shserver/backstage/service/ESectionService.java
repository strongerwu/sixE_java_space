package com.shserver.backstage.service;

import java.util.List;

import com.shserver.datacenter.domain.ESection;

public interface ESectionService {
	
	public List<ESection> queryList();
	
	public List<ESection> queryByType(String type);
	
	public ESection queryById(Integer id);
	
	public void insert(ESection es);
	
	public void update(ESection es);
	
}
