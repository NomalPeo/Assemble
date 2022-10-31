package com.assemble.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.assemble.service.UsersService;
import com.assemble.vo.UsersVO;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		System.out.println("Login 성공");
		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		}); // 로그인한 사용자에게 부여한 권한을 구해서 
		String username = request.getParameter("login_id");
		System.out.println(username);
		
		System.out.println("ROLE NAMES : " + roleNames); // 사용자 권한을 출력
		
		if(roleNames.contains("ROLE_USER")) { // 관리자 권한 일때 
			response.sendRedirect("main");
			return;
		}
		
		if(roleNames.contains("ROLE_ADMIN")) { // 일반 회월일때
			response.sendRedirect("/admin/adminPage");
			return;
		}
		response.sendRedirect("/");
	}

}
