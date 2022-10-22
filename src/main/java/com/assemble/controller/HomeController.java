package com.assemble.controller;

import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assemble.vo.WebtoonVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	@RequestMapping("main")
	public String main() {
		return "index_1";
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

	
	@GetMapping("/accessError") // get으로 접근하는 accessError 매핑주소가 실행
	public void accessDenied(Model model) {
		// 리턴 타입이 없는 void형이면 매핑주소가 jsp뷰페이지 파일명이 된다.
		System.out.println("access Denied");
		model.addAttribute("msg", "Access Denied"); // 뷰페이지에서 EL로 ${msg} 키이름을 참조해서 값을 가져온다.
	}

	
	@GetMapping("/customLogout") // get방식일때 실행
	public void logoutGET() {
		
	}
	
	@PostMapping("/customLogout") // post방식일때 실행 => 같은 매핑주소라도 메서드 방식이 다르면 사용이 가능하다.
	public void logoutPOST() {
		
	}
	
}
