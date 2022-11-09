package com.assemble.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.WishService;
import com.assemble.vo.ThemaVO;
import com.assemble.vo.UsersVO;
import com.assemble.vo.WebtoonVO;
import com.assemble.vo.WishVO;

@Controller
public class WishController {

   @Autowired
   private WishService wishService;

   @RequestMapping(value="/wish", method=RequestMethod.GET)
   public String thema_content (Model contM, HttpServletRequest request, WishVO wl, Principal principal){

	  String user_id = principal.getName();
	  wl.setWish_id(user_id);
      List<WishVO> w_list = this.wishService.getWish(wl);

      contM.addAttribute("w_list", w_list);
      contM.addAttribute("wishmsg", "찜목록이 없습니다.");

      return "myPage/wish";
   }

   @RequestMapping(value="/wish_ok", method=RequestMethod.POST)
   public ModelAndView wish_ok (WishVO wo, HttpServletRequest request,Principal prin) {
	  ModelAndView mc = new ModelAndView();
	  String user_id = prin.getName();
	  wo.setWish_id(user_id);
	  String thumbnail = request.getParameter("thumbnail");
      String title = request.getParameter("title");
      wo.setWish_thumbnail(thumbnail);
      wo.setWish_title(title);

      this.wishService.wish_ok(wo);

      return new ModelAndView("redirect:/wish");
      }
   
   
   @RequestMapping("/wish_del")
   public String wish_del(String wish_title, RedirectAttributes rttr) {
      this.wishService.deleteWish(wish_title);
      rttr.addFlashAttribute("msg","SUCCESS");
      return "redirect:/wish";
   }
   
}