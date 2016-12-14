package com.shserver.gateway.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shserver.backstage.service.ContentService;
import com.shserver.base.Contants;
import com.shserver.datacenter.domain.EContent;
import com.shserver.datacenter.domain.ESection;
import com.shserver.gateway.dto.DataReturn;
import com.shserver.gateway.dto.ResultCode;
import com.shserver.gateway.service.GateWayService;
import com.shserver.gateway.utils.JsonUtil;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	private static final Logger logger = Logger.getLogger(MenuController.class); 
	@Autowired
	private GateWayService gateWayService;
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="/goMenuList.do")
	@ResponseBody
	public String menuList(){
		DataReturn data = new DataReturn();
		//默认传参数为1
		List<ESection> list = gateWayService.queryByTypeAndStatus(Contants.WORLD_INTEGRATION);
		data.setData(list);
		data.setCode(ResultCode.SUCCESS);
		data.setMessage("查询成功");
		String json = JsonUtil.object2json(data);
		return json;
	}
	/**
	 * 查询子菜单
	 * @return
	 */
	@RequestMapping(value="/goMenuDetailList.do")
	@ResponseBody
	public String menuDetailList(String type){
		DataReturn data = new DataReturn();
		if(StringUtils.isBlank(type)){
			data.setCode(ResultCode.FAILURE);
			data.setMessage("参数[type]为空");
		}
		List<EContent> list = gateWayService.queryBySeType(type);
		data.setData(list);
		data.setCode(ResultCode.SUCCESS);
		data.setMessage("查询子菜单成功");
		String json = JsonUtil.object2json(data);
		return json;
	}
}
