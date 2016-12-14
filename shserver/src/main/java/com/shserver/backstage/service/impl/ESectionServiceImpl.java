package com.shserver.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shserver.backstage.service.ESectionService;
import com.shserver.datacenter.dao.ESectionDao;
import com.shserver.datacenter.domain.ESection;

@Service(value = "eSectionService")
public class ESectionServiceImpl implements ESectionService{

	@Autowired
	private ESectionDao eSectionDao;
	
	@Override
	public List<ESection> queryByType(String type) {
		return eSectionDao.queryByType(type);
	}

	@Override
	public ESection queryById(Integer id) {
		// TODO Auto-generated method stub
		return eSectionDao.queryById(id);
	}

	@Override
	public List<ESection> queryList() {
		return eSectionDao.queryList();
	}

	@Override
	public void insert(ESection es) {
		eSectionDao.insert(es);
	}

	@Override
	public void update(ESection es) {
		eSectionDao.update(es);
	}

}
