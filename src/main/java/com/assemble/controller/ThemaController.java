package com.assemble.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.ThemaService;
import com.assemble.vo.ThemaVO;
import com.assemble.vo.WebtoonVO;
import com.assemble.vo.WishVO;

@Controller
public class ThemaController {

   @Autowired
   private ThemaService themaService;

   @RequestMapping(value = "/thema", method = RequestMethod.GET)
   public String thema() {
      return "thema/thema";
   }

   @RequestMapping(value="/thema_content", method=RequestMethod.GET)
   public String thema_content (Model contM, HttpServletRequest request, ThemaVO tb){
      
      List<ThemaVO> conlist = this.themaService.getWebtoonList1(tb);

      contM.addAttribute("conlist", conlist);
      contM.addAttribute("contmsg", "테마목록이 없습니다.");

      return "thema/thema_content";
   }
   
   @RequestMapping(value="/thema_content2", method=RequestMethod.GET)
   public String thema_content2 (Model contM, HttpServletRequest request, WishVO wsb){
      
      List<WishVO> conlist2 = this.themaService.getWishList(wsb);
      

      contM.addAttribute("conlist2", conlist2);
      contM.addAttribute("contmsg", "테마목록이 없습니다.");

      return "thema/thema_content2";
   }
   
   @RequestMapping(value="/thema_content3", method=RequestMethod.GET)
   public String thema_content3 (Model contM, HttpServletRequest request, WishVO wsb){
      
      List<WishVO> conlist3 = this.themaService.getWishList_male(wsb);
      

      contM.addAttribute("conlist3", conlist3);
      contM.addAttribute("contmsg", "테마목록이 없습니다.");

      return "thema/thema_content3";
   }
   
   @RequestMapping(value="/thema_content4", method=RequestMethod.GET)
   public String thema_content4 (Model contM, HttpServletRequest request, WishVO wsb){
      
      List<WishVO> conlist4 = this.themaService.getWishList_female(wsb);
      

      contM.addAttribute("conlist4", conlist4);
      contM.addAttribute("contmsg", "테마목록이 없습니다.");

      return "thema/thema_content4";
   }
   
   @RequestMapping(value="/thema_insert", method=RequestMethod.GET)
   public String thema_insert (Model thinsertM, HttpServletRequest request, WebtoonVO wb) {
      
      List<WebtoonVO> thlist = this.themaService.getWebtoonList(wb);
      
      thinsertM.addAttribute("thlist", thlist);

      return "insert/thema_insert";
   }
   
   @RequestMapping(value="/thema_insert_ok", method=RequestMethod.POST)
   public ModelAndView thema_insert_ok (ThemaVO tm, RedirectAttributes rttr) {
      this.themaService.insertThema(tm);
      rttr.addFlashAttribute("msg","SUCCESS");
      return new ModelAndView("redirect:/thema_content");
   }
   
   @RequestMapping("/thema_del")
   public String thema_del(String thema_title, RedirectAttributes rttr) {
      this.themaService.deleteThema(thema_title);
      rttr.addFlashAttribute("msg","SUCCESS");
      return "redirect:/thema_content";
   }
   
}