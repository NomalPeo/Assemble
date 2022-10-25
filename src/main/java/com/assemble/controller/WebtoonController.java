package com.assemble.controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assemble.service.WebtoonService;
import com.assemble.vo.WebtoonVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebtoonController {

	@Autowired
	private WebtoonService webtoonService;

	@RequestMapping("/webtooninsert")
	public String webtooninsert() {

		return "insert/webtooninsert";
	}

	

	@PostMapping("webinsert3")
	public String webinsert3(HttpServletRequest request, HttpServletResponse response, WebtoonVO wb) throws Exception {
		PrintWriter out = response.getWriter();
		String saveFolder = request.getRealPath("/resources/upload");
		System.out.println(saveFolder);
		int fileSize = 5 * 1024 * 1024; // 이진파일 업로드 최대크기(5M)

		MultipartRequest multi = null;

		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");

		String webtoon_title = multi.getParameter("webtoon_title");
		String webtoon_writer = multi.getParameter("webtoon_writer");
		String webtoon_cont = multi.getParameter("webtoon_cont");
		String webtoon_tag1 = multi.getParameter("webtoon_tag1");
		String webtoon_tag2 = multi.getParameter("webtoon_tag2");
		int webtoon_complete = Integer.parseInt(multi.getParameter("webtoon_complete"));
		String webtoon_platform = multi.getParameter("webtoon_platform");
		File webtoon_thumbnail_ = multi.getFile("webtoon_thumbnail");
		File webtoon_image1_ = multi.getFile("webtoon_image1");
		File webtoon_image2_ = multi.getFile("webtoon_image2");
		File webtoon_image3_ = multi.getFile("webtoon_image3");
		String webtoon_thumbnail = webtoon_thumbnail_.getName();
		String webtoon_image1 = webtoon_image1_.getName();
		String webtoon_image2 = webtoon_image2_.getName();
		String webtoon_image3 = webtoon_image3_.getName();

		File uploadPath = new File(saveFolder, webtoon_title);
		uploadPath.mkdirs();

		wb.setWebtoon_title(webtoon_title);
		wb.setWebtoon_writer(webtoon_writer);
		wb.setWebtoon_cont(webtoon_cont);
		wb.setWebtoon_complete(webtoon_complete);
		wb.setWebtoon_platform(webtoon_platform);
		wb.setWebtoon_tag1(webtoon_tag1);
		wb.setWebtoon_tag2(webtoon_tag2);
		wb.setWebtoon_thumbnail(webtoon_thumbnail);
		wb.setWebtoon_image1(webtoon_image1);
		wb.setWebtoon_image2(webtoon_image2);
		wb.setWebtoon_image3(webtoon_image3);

		this.webtoonService.insertwebtoon(wb);
		return "index";
	}
	

	
	@RequestMapping(value = "/tagpage_tag", method = RequestMethod.GET)
	public String tagPage(Model listM, HttpServletRequest request, WebtoonVO wb) {

		int page = 1;
		int limit = 20; // 한 페이지에 보여지는 목록 개수
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		String find_name = request.getParameter("find_name"); // 검색어
		String find_field = request.getParameter("find_field"); // 검색 필드
		wb.setFind_name("%" + find_name + "%");
		wb.setFind_field(find_field);

		int totalCount = this.webtoonService.getListCount(wb);
		// 검색 전 총 레코드 개수, 검색 후 총 레코드 개수

		wb.setStartrow((page - 1) * 10 + 1); // 시작행 번호
		wb.setEndrow(wb.getStartrow() + limit - 1); // 끝행 번호

		List<WebtoonVO> wblist = this.webtoonService.getWebtoonList(wb); // 검색 전후 목록

		// 총 페이지수
		int maxpage = (int) ((double) totalCount / limit + 0.95);

		// 시작페이지(1, 11, 21, ...)
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage = maxpage;
		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		listM.addAttribute("wblist", wblist);
		listM.addAttribute("page", page);
		listM.addAttribute("startpage", startpage);
		listM.addAttribute("endpage", endpage);
		listM.addAttribute("maxpage", maxpage);
		listM.addAttribute("listcount", totalCount);
		listM.addAttribute("find_field", find_field); // 검색 필드 저장
		listM.addAttribute("find_name", find_name); // 검색어 저장

		return "tagpage/tag";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}