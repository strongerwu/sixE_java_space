package com.shserver.backstage.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shserver.backstage.service.ESectionService;
import com.shserver.base.SpringContextHolder;
import com.shserver.base.utils.Tools;
import com.shserver.datacenter.domain.ESection;

@Controller
@RequestMapping(value = "/sectionData")
public class SectionDataController {

	private static final Logger logger =Logger.getLogger(SectionDataController.class);
	
	@Autowired
	private ESectionService eSectionService;
	
	@ResponseBody
	@RequestMapping(value = "/getList.do")
	public String getList(){
		logger.info("####获取栏目集合");
		List<ESection> list = eSectionService.queryList();
		if(Tools.isEmpty(list)){
			return Tools.sendJson("FIL");
		}
		System.out.println(list.toString());
		return Tools.sendJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryOne.do")
	public String queryOne(String id){
		logger.info("####获取栏目:【"+id+"】");
		ESection es = eSectionService.queryById(Integer.parseInt(id));
		if(Tools.isEmpty(es)){
			return Tools.sendJson("FIL");
		}
		return Tools.sendJson(es);
	}
	
	@RequestMapping(value = "/updateOne.do")
	public String updateOne(String id,String seName,String seStatus,String seType,String seDesc,
			HttpServletRequest request,
			HttpServletResponse response){
		logger.info("####修改:"+id);
		ESection es = eSectionService.queryById(Integer.parseInt(id));
		es.setSeName(seName);
		es.setSeDesc(seDesc);
		es.setSeStatus(Integer.parseInt(seStatus));
		es.setSeType(Integer.parseInt(seType));
		try {
			eSectionService.update(es);
			logger.info("####修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("####修改失败!!!!!!");
			e.printStackTrace();
			return "page/backstage/menuConfig";
		}
		return "page/backstage/menuConfig";
	}
	
	@RequestMapping(value = "/addOne.do")
	public String addOne(String seName,String seStatus,String seType,String seDesc,
			HttpServletRequest request,
			HttpServletResponse response){
		ESection es = new ESection();
		es.setSeName(seName);
		es.setSeDesc(seDesc);
		es.setSeStatus(Integer.parseInt(seStatus));
		es.setSeType(Integer.parseInt(seType));
		es.setSeCreateUserId(SpringContextHolder.getCurrentUser().getId());
		logger.info("####新增栏目："+es.toString());
		
		try {
			eSectionService.insert(es);
			logger.info("####添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("####添加失败!!!!");
			e.printStackTrace();
			return "page/backstage/menuConfig";
		}
		return "page/backstage/menuConfig";
	}
}
