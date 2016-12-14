package com.shserver.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shserver.backstage.service.ContentService;
import com.shserver.datacenter.dao.ContentDao;
import com.shserver.datacenter.domain.EContent;

@Service(value = "contentService")
public class ContentServiceImpl implements ContentService{

	@Autowired
	private ContentDao contentDao;
	
	@Override
	public List<EContent> queryByType(String type) {
		return contentDao.queryByType(type);
	}

	@Override
	public void addOne(EContent e) {
		contentDao.addOne(e);
	}

	@Override
	public void updOne(EContent e) {
		contentDao.updOne(e);
	}

	@Override
	public EContent queryOne(Integer id) {
		return contentDao.queryOne(id);
	}
	
}
