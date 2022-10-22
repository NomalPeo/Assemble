package com.assemble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class CommonController {
	
	@GetMapping("/accessError") // get으로 접근하는 accessError 매핑주소가 실행
	public void accessDenied(Model model) {
		// 리턴 타입이 없는 void형이면 매핑주소가 jsp뷰페이지 파일명이 된다.
		System.out.println("access Denied");
		model.addAttribute("msg", "Access Denied"); // 뷰페이지에서 EL로 ${msg} 키이름을 참조해서 값을 가져온다.
	}
	@RequestMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error : " + error);
		System.out.println("logout : " + logout);
		
		if(error != null) {
			model.addAttribute("error","Login Error Check Your Account");
		}
		if(logout != null) {
			model.addAttribute("logout", "LogOut!!");
		}
	}// customLogin 매핑주소
	
	@GetMapping("/customLogout") // get방식일때 실행
	public void logoutGET() {
		
	}
	
	@PostMapping("/customLogout") // post방식일때 실행 => 같은 매핑주소라도 메서드 방식이 다르면 사용이 가능하다.
	public void logoutPOST() {
		
	}
}
