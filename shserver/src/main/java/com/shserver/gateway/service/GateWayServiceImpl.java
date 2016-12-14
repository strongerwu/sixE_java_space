package com.shserver.gateway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shserver.datacenter.dao.ContentDao;
import com.shserver.datacenter.dao.ESectionDao;
import com.shserver.datacenter.domain.EContent;
import com.shserver.datacenter.domain.ESection;

@Service(value="gateWayService")
public class GateWayServiceImpl implements GateWayService{

	@Autowired
	private ESectionDao eSectionDao;
	
	@Autowired
	private ContentDao contentDao;
	
	public List<ESection> queryByTypeAndStatus(String type) {
		return eSectionDao.queryByStatusAndType(type);
	}
	
	public List<EContent> queryBySeType(String type) {
		return contentDao.queryBySeType(type);
	}

}
