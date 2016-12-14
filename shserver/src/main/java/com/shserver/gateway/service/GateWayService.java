package com.shserver.gateway.service;

import java.util.List;

import com.shserver.datacenter.domain.EContent;
import com.shserver.datacenter.domain.ESection;

public interface GateWayService {

	/**
	 * 查询当前已启用的栏目
	 */
	public List<ESection> queryByTypeAndStatus(String type);
	/**
	 * 通过栏目id查询已启用的子栏目
	 * @param type
	 * @return
	 */
	public List<EContent> queryBySeType(String type);
	
}
