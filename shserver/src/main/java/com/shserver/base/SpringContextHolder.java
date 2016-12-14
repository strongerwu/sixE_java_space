package com.shserver.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.shserver.datacenter.domain.EUsers;

public class SpringContextHolder {

	public static ServletRequestAttributes getSrAttrs() {
		ServletRequestAttributes srAttrs = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return srAttrs;
	}
	
	public static HttpSession getSession() {
		return getSrAttrs().getRequest().getSession();
	}
	
	public static EUsers getCurrentUser() {
		return (EUsers)getSession().getAttribute(Contants.USER_SESSION_INFO);
	}
	
	public static HttpServletRequest getRequest() {
		return getSrAttrs().getRequest();
	}
}
