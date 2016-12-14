package com.shserver.backstage.service;

import java.util.List;

import com.shserver.datacenter.domain.EContent;

public interface ContentService {

	public List<EContent> queryByType(String type);
	
	public void addOne(EContent e);
	
	public void updOne(EContent e);
	
	public EContent queryOne(Integer id);
}
