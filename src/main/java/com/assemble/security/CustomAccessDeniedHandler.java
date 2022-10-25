package com.assemble.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		/* 403접근 금지 에러가 발생한 경우 보다 더 다양한 처리를 하고 싶다면 스프링 api 인터페이스 AccessDeniedHandler 인터페이스를 
		 * 구현해서 사용하면 된다.*/
		System.out.println("Access Denied Handler");
		System.out.println("Redirect..........");
		response.sendRedirect("/accessError"); // 서블릿을 사용해서 accessError매핑주소로 이동한다.
	}

}
