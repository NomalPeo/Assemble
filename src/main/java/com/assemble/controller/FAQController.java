package com.assemble.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.FAQService;
import com.assemble.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;

@Controller
public class FAQController {
	
	@Autowired
	private FAQService faqService;
	
	// 회원만 글쓰기
	@RequestMapping(value="/qna_write", method=RequestMethod.GET)
	public ModelAndView qna_write(HttpServletRequest request, HttpServletResponse response, 
			Principal principal) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		//String id = (String)session.getAttribute("id");
		request.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			String id = principal.getName();
			if(id == null) {
				out.println("<script>");
				out.println("alert('로그인이 필요한 서비스 입니다.');");
				out.println("location='qna_list';");
				out.println("</script>");
			}else {
				int page=1;
				if(request.getParameter("page")!=null){
					page=Integer.parseInt(request.getParameter("page"));
				}
				ModelAndView wm = new ModelAndView("board/FAQ/qna_write");
				wm.addObject("page", page);
				return wm;
			}
			
		}catch(Exception e) {
			
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스 입니다.');");
			out.println("location='qna_list';");
			out.println("</script>");
		}
		return null;
	}// qna_write()
	
	// 게시판 저장
	@RequestMapping(value="/qna_write",method=RequestMethod.POST)
	public ModelAndView qna_write_ok(BoardVO b, Principal principal,RedirectAttributes rttr) {
		
		String board_writer = principal.getName();
		System.out.println(board_writer);
		b.setBoard_writer(board_writer);
		
		this.faqService.insertBoard(b);
		rttr.addFlashAttribute("msg","SUCCESS");
		return new ModelAndView("redirect:/qna_list");
	} // freeboard_write_ok()
	
	@GetMapping("qna_list")
	public String qna_list(Model m, BoardVO b, HttpServletRequest request) {
		
		/*아래부터 검색기능*/
		int page=1;
		int limit=20;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		String find_name=request.getParameter("find_name"); // 검색어
		String find_field=request.getParameter("find_field"); // 검색
		// 필드
		if(find_field ==null) {
			find_field = "";
		}
		b.setFind_field(find_field);
		b.setFind_name("%"+find_name+"%");
		
		int listcount = this.faqService.getRowCount(b);
		// 전체 레코드 개수 또는 검색전후 레코드 개수
		/*윗줄 까지*/
		
		b.setStartrow((page-1)*20+1);
		b.setEndrow(b.getStartrow()+limit-1);
		
		List<BoardVO> blist=this.faqService.getBoardList(b);
		System.out.println(blist);
		for (BoardVO list : blist) {
			int list2 = list.getBoard_type();
			System.out.println(list2);
		}
		/*페이징*/
		int maxpage=(int)((double)listcount/limit+0.95); // 총페이지수
		int startpage=(((int)((double)page/10+0.9))-1)*10+1; // 시작페이지
		int endpage=maxpage; // 현재 페이지에 보여질 마지막 페이지
		
		if(endpage > startpage + 10-1) endpage=startpage+10-1;
		
		m.addAttribute("list",blist);// list키이름에 목록 저장
		m.addAttribute("listcount",listcount);
		m.addAttribute("startpage",startpage);
		m.addAttribute("endpage",endpage);
		m.addAttribute("maxpage",maxpage);
		m.addAttribute("find_name",find_name);   
		m.addAttribute("find_field",find_field);
		m.addAttribute("page",page);
		
		return "/board/FAQ/qna_list";
	} // freeboard_list()
	
	// 게시물 내용보기
		@RequestMapping("qna_cont")
		public ModelAndView qna_cont(@RequestParam("board_no")int board_no, @RequestParam("page")int page) {
			
			BoardVO bc = faqService.getqnaCont(board_no);
			String cont = bc.getBoard_cont().replace("\n", "<br/>");
			
			ModelAndView cm = new ModelAndView();
			cm.addObject("b", bc);
			cm.addObject("cont", cont);
			cm.addObject("page", page);
			cm.setViewName("board/FAQ/qna_cont");
			
			return cm;
		} // freeboard_cont()
		
		// 게시물 수정
		@GetMapping("qna_edit")
		public String qna_edit(Model em, int board_no, int page) {
			
			BoardVO eb = this.faqService.getQnaBoardCont2(board_no);
			
			em.addAttribute("b", eb);
			em.addAttribute("page", page);
			return "board/FAQ/qna_edit";
		} // freeboard_edit()
		
		// 게시물 수정 완료
		@RequestMapping("qna_edit_ok")
		public ModelAndView freeboard_edit_ok(int board_no, int page, BoardVO eb) {
			faqService.editBoard(eb);
			
			ModelAndView em = new ModelAndView();
			em.setViewName("redirect:qna_cont");
			em.addObject("board_no", eb.getBoard_no());
			em.addObject("page", page);
			return em;
		} // freeboard_edit_ok()
		
		// 게시물 삭제
		@RequestMapping("/qna_del")
		public String qnaboard_del(int board_no, int page, RedirectAttributes rttr) {
			this.faqService.delqnaBoard(board_no);
			
			rttr.addAttribute("msg", "SUCCESS");
			return "redirect:/qna_list?page="+page;
		}
	
}
