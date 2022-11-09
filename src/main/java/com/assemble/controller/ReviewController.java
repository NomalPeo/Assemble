package com.assemble.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.ReviewService;
import com.assemble.vo.ReviewVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value ="/content_review", method=RequestMethod.POST)
	public String insertreview(Model m, ReviewVO rv, HttpServletRequest request, Principal principal) throws Exception{
		
		String review_id = principal.getName();
		rv.setReview_id(review_id);
		String review_cont = request.getParameter("review_cont");
		rv.setReview_cont(review_cont);
		String review_thumbnail = request.getParameter("review_thumbnail");
		reviewService.insertReview(rv);
		
		review_thumbnail = URLEncoder.encode(review_thumbnail, "UTF-8");
		
		String url = "redirect:/content?webtoon_thumbnail=" + review_thumbnail;
		
		return url;
		
	}
	
	@RequestMapping("/review_del")
	public String delreview(HttpServletRequest request, int review_no, RedirectAttributes rttr,HttpServletResponse response) throws IOException {
		this.reviewService.del_review(review_no);
		String thumbnail = request.getParameter("review_thumbnail");
		rttr.addAttribute("msg", "SUCCESS");
		thumbnail = URLEncoder.encode(thumbnail, "UTF-8");

		String url = "redirect:/content?webtoon_thumbnail=" + thumbnail;
		
		return url;
	}

}
