package com.assemble.controller;

import java.awt.*;
import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assemble.service.WebtoonService;
import com.assemble.vo.WebtoonVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private WebtoonService webtoonService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");// 브라우저에 출력되는 문자/태그, 언어코딩 타입을 설정
		


		return "index";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model,WebtoonVO wb) {
		List<WebtoonVO> wlist4 = this.webtoonService.RomanceGetWebtoonList1(wb);
		List<WebtoonVO> wlist1 = this.webtoonService.RomanceGetWebtoonList2(wb);
		List<WebtoonVO> wlist2 = this.webtoonService.RomanceGetWebtoonList3(wb);
		List<WebtoonVO> wlist3 = this.webtoonService.RomanceGetWebtoonList4(wb);
		
		List<WebtoonVO> glist1 = this.webtoonService.ThrillerWebtoonList1(wb);
		List<WebtoonVO> glist2 = this.webtoonService.ThrillerWebtoonList2(wb);
		List<WebtoonVO> glist3= this.webtoonService.ThrillerWebtoonList3(wb);
		List<WebtoonVO> glist4= this.webtoonService.ThrillerWebtoonList4(wb);

		List<WebtoonVO> alist1 = this.webtoonService.ActionWebtoonList1(wb);
		List<WebtoonVO> alist2 = this.webtoonService.ActionWebtoonList2(wb);
		List<WebtoonVO> alist3= this.webtoonService.ActionWebtoonList3(wb);
		List<WebtoonVO> alist4= this.webtoonService.ActionWebtoonList4(wb);




		model.addAttribute("wlist1",wlist1);
		model.addAttribute("wlist2",wlist2);
		model.addAttribute("wlist3",wlist3);
		model.addAttribute("wlist4",wlist4);
		
		model.addAttribute("glist1",glist1);
		model.addAttribute("glist2",glist2);
		model.addAttribute("glist3",glist3);
		model.addAttribute("glist4",glist4);

		model.addAttribute("alist1",alist1);
		model.addAttribute("alist2",alist2);
		model.addAttribute("alist3",alist3);
		model.addAttribute("alist4",alist4);

		return "index_1";
		
	}

    @GetMapping("/accessError") // get으로 접근하는 accessError 매핑주소가 실행
    public void accessDenied(Model model) {
        // 리턴 타입이 없는 void형이면 매핑주소가 jsp뷰페이지 파일명이 된다.
        System.out.println("access Denied");
        model.addAttribute("msg", "Access Denied"); // 뷰페이지에서 EL로 ${msg} 키이름을 참조해서 값을 가져온다.
    }

	
}
