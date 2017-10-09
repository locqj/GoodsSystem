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
	// 日志
	protected Logger log = Logger.getLogger(getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		System.out.printf("asd");
		// 创建session
		HttpSession session = request.getSession();

//		// 无需登录，允许访问的地址
//		String[] allowUrls = new String[] { "/", "/register", "/login", "/logout"};
//
//		// 获取请求地址
//		String url = request.getRequestURL().toString();

		// 获得session中的用户
		String user = (String) session.getAttribute("username");
		System.out.print(user);
	
		
		if (user == null) {
			// 重定向
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
