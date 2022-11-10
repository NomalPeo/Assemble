package com.assemble.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.ReverbType;

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
	public String insertreview(Model m, ReviewVO rv, HttpServletRequest request, Principal principal,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		String url = "redirect:/tagpage_tag";
		String review_cont = request.getParameter("review_cont");
		String review_thumbnail = request.getParameter("review_thumbnail");
		try {
			String review_id = principal.getName();
			if(review_id == null) {
				out.println("<script>");
				out.println("alert('로그인하십시요');");
				out.println("location='/main';");
				out.println("</script>");
			}
			rv.setReview_id(review_id);
			rv.setReview_cont(review_cont);
			reviewService.insertReview(rv);

			review_thumbnail = URLEncoder.encode(review_thumbnail, "UTF-8");

			url = "redirect:/content?webtoon_thumbnail=" + review_thumbnail;

		}catch(Exception e) {
			e.printStackTrace();
		}

		return url;
	}

	@RequestMapping("/review_del")
	public String delreview(HttpServletRequest request, int review_no, RedirectAttributes rttr,
			HttpServletResponse response,Principal principal) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String thumbnail = request.getParameter("review_thumbnail");
		String review_id = request.getParameter("review_id");
		String writer = principal.getName();
		try {
			if(review_id.equals(writer)) {
				this.reviewService.del_review(review_no);
				rttr.addAttribute("msg", "SUCCESS");
				thumbnail = URLEncoder.encode(thumbnail, "UTF-8");
				out.println("<script>");
				out.println("alert('댓글삭제.');");
				out.println("history.back();");
				out.println("</script>");
			}else{
				
				out.println("<script>");
				out.println("alert('지울수 없읍니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}

}
