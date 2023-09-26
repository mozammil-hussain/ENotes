package com.enotes.config;

import com.enotes.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthHandler implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		User user=(User)request.getSession().getAttribute("userObj");
		
		if(user!=null)
		{
			return true;
		}else {
			/* response.sendRedirect("login"); */
			
			response.getWriter().print("<h1>Getting </h1>");
			return false;
		}
		
	}

}
