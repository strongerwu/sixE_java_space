package com.shserver.backstage.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shserver.backstage.service.ContentService;
import com.shserver.backstage.service.ESectionService;
import com.shserver.base.SpringContextHolder;
import com.shserver.base.utils.Tools;
import com.shserver.datacenter.domain.EContent;
import com.shserver.datacenter.domain.ESection;

@Controller
@RequestMapping(value = "/contentData")
public class ContentDataController {

	private static final Logger logger = Logger.getLogger(ContentDataController.class);
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ESectionService eSectionService;
	
	@ResponseBody
	@RequestMapping(value = "/getList.do")
	public String getList(String type){
		logger.info("获取list请求 -type:【"+type+"】");
		List<EContent> list = contentService.queryByType(type);
		if(Tools.isEmpty(list)){
			return Tools.sendJson("FIL");
		}
		System.out.println(list.toString());
		return Tools.sendJson(list);
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryUpdOne.do")
	public String queryUpdOne(String id){
		logger.info("获取list修改内容详细信息id:"+id);
		EContent e = contentService.queryOne(Integer.valueOf(id));
		if(Tools.isEmpty(e)){
			return Tools.sendJson("FIL");
		}
		return Tools.sendJson(e);
	}
	
	@RequestMapping(value = "/updOne.do")
	public String updOne(String id,String coTitle,String coDesc,String coUrl,String coStatus,HttpServletRequest request,
			HttpServletResponse response){
		logger.info("####修改内容："+id);
		EContent ec = contentService.queryOne(Integer.valueOf(id));
		ec.setCoTitle(coTitle);
		ec.setCoUrl(coUrl);
		ec.setCoDesc(coDesc);
		ec.setCoStatus(Integer.valueOf(coStatus));
		ESection es = eSectionService.queryById(ec.getCoSeType());
		request.setAttribute("es", es);
		try {
			contentService.updOne(ec);
			return "page/backstage/showList";
		} catch (Exception e1) {
			e1.printStackTrace();
			request.setAttribute("type", ec.getCoSeType());
			return "page/backstage/showList";
		}
	}
	
	@RequestMapping(value = "/addOne.do")
	public String addOne(String coSeType,String coTitle,String coUrl,String coStatus,String coDesc,HttpServletRequest request,
			HttpServletResponse response){
		logger.info("####新增类型：【"+coSeType+"】");
		EContent e= new EContent();
		e.setCoSeType(Integer.parseInt(coSeType));
		e.setCoTitle(coTitle);
		e.setCoUrl(coUrl);
		e.setCoStatus(Integer.parseInt(coStatus));
		e.setCoDesc(coDesc);
		e.setCoType(1);
		e.setCoCreateUserId(SpringContextHolder.getCurrentUser().getId());
		logger.info("####新增内容："+e.toString());
		ESection es = eSectionService.queryById(Integer.parseInt(coSeType));
		request.setAttribute("es", es);
		try {
			contentService.addOne(e);
			logger.info("#####添加成功");
			request.setAttribute("type", coSeType);
			return "page/backstage/showList";
		} catch (Exception e1) {
			logger.error("#####添加失败....");
			request.setAttribute("type", coSeType);
			return "page/backstage/showList";
		}
	}
}
