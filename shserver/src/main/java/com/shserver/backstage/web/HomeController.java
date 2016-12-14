package com.shserver.backstage.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shserver.backstage.service.UserService;
import com.shserver.base.Contants;
import com.shserver.base.SpringContextHolder;
import com.shserver.base.imgCode.ValidateCode;
import com.shserver.base.utils.SignUtil;
import com.shserver.base.utils.Tools;
import com.shserver.datacenter.domain.EUsers;

@Controller
@RequestMapping("/home")
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index.do")
	public String index(){
		return "page/backstage/login";
	}
	/**
	 * 图片验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/randomImg.do")
	public void randomImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        //禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);
        ValidateCode vCode = new ValidateCode(120,40,5,100,response); 
        vCode.write(response.getOutputStream()); 
        logger.info("刷新imgCode---->"+vCode.getCode());
        request.getSession().setAttribute("code", vCode.getCode());  
	}
	/**
	 * 验证图片验证码
	 * @param code
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/checkCode.do")
	public String checkCode(String code,HttpServletRequest request, HttpServletResponse response){
		String sessionCode = (String) request.getSession().getAttribute("code");
		/*设置不区分大小写  全部转为大写比较*/
		String newSessionCode = sessionCode.toUpperCase();
		String newCode = code.toUpperCase();
		if(newSessionCode.equals(newCode)){
			return Tools.sendJson("SUC");
		}
		return Tools.sendJson("FIL");
	}
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doLogin.do")
	public String doLogin(String userName,String password){
		EUsers user = userService.loginQuery(userName, SignUtil.cryptMd5(password));
		if(Tools.isEmpty(user)){
			return Tools.sendJson("用户名或密码错误...");
		}
		logger.info("登录用户："+user.toString());
		SpringContextHolder.getSession().setAttribute(Contants.USER_SESSION_INFO, user);
		return Tools.sendJson("SUC");
	}
	
	/**
	 * 退出系统
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/exit.do")
	public String exit(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Enumeration e = SpringContextHolder.getSession().getAttributeNames();   
		while (e.hasMoreElements()){  
			SpringContextHolder.getRequest().getSession().removeAttribute(e.nextElement().toString());
		}
		return "redirect:/home/index.do";
	}
}
