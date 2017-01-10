package com.rock.book.utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("sessionInterceptor")
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);

	//	String reqUri = request.getRequestURI().substring(request.getContextPath().length());
		/*System.out.println("URL = "+request.getRequestURL());
		System.out.println("URI = "+request.getRequestURI().substring(request.getContextPath().length()));
		System.out.println("Context = "+request.getContextPath());
		System.out.println("URI(Without Context) = "+reqUri);
		System.out.println("세션인터셉터 16.09.08");*/
		/*
		
		if (session == null) {
			throw new ModelAndViewDefiningException(new ModelAndView("/login"));
			
		} else {
			if(session.getAttribute("loginInfo") == null) {
				throw new ModelAndViewDefiningException(new ModelAndView("/login"));
			}
		}*/
		
		return true;
	}
}