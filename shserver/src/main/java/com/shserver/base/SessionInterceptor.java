package com.shserver.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shserver.base.utils.Tools;

public class SessionInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object o) throws Exception {
		// TODO Auto-generated method stub
		if (Tools.isEmpty(SpringContextHolder.getSession())) {
			resp.sendRedirect("/shserver/home/exit.do");
			return false;
		}else if(Tools.isEmpty(SpringContextHolder.getSession().getAttribute(Contants.USER_SESSION_INFO))){
			resp.sendRedirect("/shserver/home/exit.do");
			return false;
		}else{
			return true;
		}
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
