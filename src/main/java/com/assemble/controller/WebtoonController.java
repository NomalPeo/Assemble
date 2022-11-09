package com.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assemble.service.WebtoonService;
import com.assemble.vo.WebtoonVO;

@Controller
public class WebtoonController {

	@Autowired
	private WebtoonService webtoonService;

	@RequestMapping("/tagpage_tag")
	public String tagPage(Model listM, HttpServletRequest request, WebtoonVO wb) {

		String webtoon_tag1 = request.getParameter("webtoon_tag1");
		String webtoon_complete = request.getParameter("webtoon_complete");
		String webtoon_platform = request.getParameter("webtoon_platform");

		if (webtoon_complete != null) {
			wb.setWebtoon_complete(webtoon_complete);
		}
		if (webtoon_tag1 != null) {
			wb.setWebtoon_tag1(webtoon_tag1);
		}
		if (webtoon_platform != null) {
			wb.setWebtoon_platform(webtoon_platform);
		}

		int page = 1;
		int limit = 150; // 한 페이지에 보여지는 목록 개수
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		String find_name = request.getParameter("find_name"); // 검색어
		String find_field = request.getParameter("find_field"); // 검색 필드
		wb.setFind_name("%" + find_name + "%");
		wb.setFind_field(find_field);

		int totalCount = this.webtoonService.getListCount(wb);
		// 검색 전 총 레코드 개수, 검색 후 총 레코드 개수

		wb.setStartrow((page - 1) * 150 + 1); // 시작행 번호
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

		listM.addAttribute("webtoon_tag1", webtoon_tag1);
		listM.addAttribute("webtoon_complete", webtoon_complete);
		listM.addAttribute("webtoon_platform", webtoon_platform);
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

	@RequestMapping(value = "/tagpage_tag1", method = RequestMethod.GET)
	public String tagPage1(Model listM, HttpServletRequest request, WebtoonVO wb) {
		String webtoon_tag1 = request.getParameter("webtoon_tag1");
		String webtoon_complete = request.getParameter("webtoon_complete");
		String webtoon_platform = request.getParameter("webtoon_platform");

		if (webtoon_complete != null) {
			wb.setWebtoon_complete(webtoon_complete);
		}
		if (webtoon_tag1 != null) {
			wb.setWebtoon_tag1(webtoon_tag1);
		}
		if (webtoon_platform != null) {
			wb.setWebtoon_platform(webtoon_platform);
		}

		int page = 1;
		int limit = 150; // 한 페이지에 보여지는 목록 개수
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		String find_name = request.getParameter("find_name"); // 검색어
		String find_field = request.getParameter("find_field"); // 검색 필드
		wb.setFind_name("%" + find_name + "%");
		wb.setFind_field(find_field);

		int totalCount = this.webtoonService.getListCount(wb);
		// 검색 전 총 레코드 개수, 검색 후 총 레코드 개수

		wb.setStartrow((page - 1) * 150 + 1); // 시작행 번호
		wb.setEndrow(wb.getStartrow() + limit - 1); // 끝행 번호

		List<WebtoonVO> wblist = this.webtoonService.getWebtoonList1(wb); // 검색 전후 목록

		// 총 페이지수
		int maxpage = (int) ((double) totalCount / limit + 0.95);

		// 시작페이지(1, 11, 21, ...)
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여질 마지막 페이지(10,20 ..)
		int endpage = maxpage;
		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		listM.addAttribute("webtoon_tag1", webtoon_tag1);
		listM.addAttribute("webtoon_complete", webtoon_complete);
		listM.addAttribute("webtoon_platform", webtoon_platform);
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