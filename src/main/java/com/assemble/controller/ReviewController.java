package com.assemble.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.ReviewService;
import com.assemble.vo.ReviewVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/tag", method = RequestMethod.GET)
	public String review_write(HttpServletRequest request){
		return "tagpage/tag";
	}
	
	@RequestMapping(value ="/tag", method = RequestMethod.POST)
	public ModelAndView review_write_ok(ReviewVO r, RedirectAttributes rttr) {
		
		this.reviewService.insertReview(r);
		rttr.addFlashAttribute("msg","SUCCESS");
		return new ModelAndView("redirect:/tag");
	}
}
