package com.assemble.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assemble.service.AdminBoardService;
import com.assemble.service.WebtoonService;
import com.assemble.vo.BoardVO;
import com.assemble.vo.WebtoonVO;			
import com.oreilly.servlet.MultipartRequest;

@Controller
@RequestMapping("/admin/*")
public class AdminOnlyController {
	@Autowired
	private WebtoonService webtoonService;
	
	@Autowired
	private AdminBoardService adminBoardService;
	
	@RequestMapping("/adminPage")
	public void adminPage(){
		
	}
	@RequestMapping("/boardmanager")
	public ModelAndView boardmanager(BoardVO vo) {
		int category = 2;
		vo.setBoard_type(category);
		List<BoardVO> bList = this.adminBoardService.getList(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("bList", bList);
		mv.setViewName("admin/boardmanager");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping("/webtooninsert")
	public String webtooninsert() {

		return "/admin/webtooninsert";
	}


	@RequestMapping(value="/webtooninsert1", method=RequestMethod.POST)
	public String webtooninsert(HttpServletRequest request, HttpServletResponse response, WebtoonVO wb) throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		String saveFolder = request.getRealPath("/resources/upload");
		System.out.println(saveFolder);
		int fileSize = 5 * 1024 * 1024; // 이진파일 업로드 최대크기(5M)

		MultipartRequest multi = null;

		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");

		String webtoon_title = multi.getParameter("webtoon_title");
		String webtoon_writer = multi.getParameter("webtoon_writer");
		String webtton_age = multi.getParameter("webtoon_age");
		String webtoon_cont = multi.getParameter("webtoon_cont");
		String webtoon_tag1 = multi.getParameter("webtoon_tag1");
		String webtoon_tag2 = multi.getParameter("webtoon_tag2");
		int webtoon_complete = Integer.parseInt(multi.getParameter("webtoon_complete"));
		String webtoon_platform = multi.getParameter("webtoon_platform");
		String webtoon_age = multi.getParameter("webtoon_age");
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
		wb.setWebtoon_age(webtoon_age);
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
		return "index_1";
	}

}
