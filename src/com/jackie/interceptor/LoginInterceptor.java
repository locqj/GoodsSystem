package com.jackie.interceptor;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import org.apache.log4j.Logger;  
import org.springframework.web.servlet.HandlerInterceptor;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jackie.vo.Users;  

public class LoginInterceptor implements HandlerInterceptor {
	
	protected Logger log = Logger.getLogger(getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		if (user == null) {
			response.sendRedirect(request.getContextPath()+"/");
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
