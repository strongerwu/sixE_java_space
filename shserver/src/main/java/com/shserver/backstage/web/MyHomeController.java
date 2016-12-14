package com.shserver.backstage.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shserver.backstage.service.ESectionService;
import com.shserver.base.Contants;
import com.shserver.base.SpringContextHolder;
import com.shserver.datacenter.domain.ESection;

@Controller
@RequestMapping(value = "/myHome")
public class MyHomeController {
	
	@Autowired
	private ESectionService eSectionService;
	
	
	@RequestMapping(value="/goMyHome.do")
	public String goMyHome(HttpServletRequest request,
			HttpServletResponse response){
		List<ESection> list1 = eSectionService.queryByType(Contants.WORLD_INTEGRATION);
		List<ESection> list2 = eSectionService.queryByType(Contants.RESOURCES);
		System.out.println(list1.size()+"----"+list2.size());
		request.setAttribute("wd_list", list1);
		request.setAttribute("re_list", list2);
		request.setAttribute("user", SpringContextHolder.getCurrentUser());
		return "page/backstage/myHome";
	}
	
	@RequestMapping(value="/showList.do")
	public String showList(String type,HttpServletRequest request,
			HttpServletResponse response){
		ESection es = eSectionService.queryById(Integer.parseInt(type));
		request.setAttribute("es", es);
		return "page/backstage/showList";
	}
	
	@RequestMapping(value = "/welcome.do")
	public String welcome(){
		return "page/backstage/welcome";
	}
	
	@RequestMapping(value = "/menuConfig.do")
	public String menuConfig(){
		System.out.println("进入栏目设置....");
		return "page/backstage/menuConfig";
	}
	
}
