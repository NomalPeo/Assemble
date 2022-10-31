package com.assemble.controller;

import java.util.List;/*게시판목록*/

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; /*게시판목록*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.FreeBoardService;
import com.assemble.vo.BoardVO;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeboardService;
	
	// 게시판 글쓰기
	@RequestMapping(value="/freeboard_write", method=RequestMethod.GET)
	public String freeboard_write(HttpServletRequest request) {
		
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", page);
		
		return "board/freeboard/freeboard_write";
	} // freeboard_write()
	
	// 게시판 저장
	@RequestMapping(value="/freeboard_write",method=RequestMethod.POST)
	public ModelAndView freeboard_write_ok(BoardVO b, RedirectAttributes rttr) {
		
		this.freeboardService.insertBoard(b);
		rttr.addFlashAttribute("msg","SUCCESS");
		return new ModelAndView("redirect:/freeboard_list");
	} // freeboard_write_ok()
	
	// 게시판 목록
	@GetMapping("freeboard_list")
	public String freeboard_list(Model m, BoardVO b, HttpServletRequest request) {
		
		int page=1;
		int limit=20;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		b.setStartrow((page-1)*20+1);
		b.setEndrow(b.getStartrow()+limit-1);
		
		int totalCount=this.freeboardService.getRowCount(); // 총레코드 개수
		List<BoardVO> blist=this.freeboardService.getBoardList(b);
		
		/*페이징*/
		int maxpage=(int)((double)totalCount/limit+0.95); // 총페이지수
		int startpage=(((int)((double)page/10+0.9))-1)*10+1; // 시작페이지
		int endpage=maxpage; // 현재 페이지에 보여질 마지막 페이지
		
		if(endpage > startpage + 10-1) endpage=startpage+10-1;
		
		m.addAttribute("list",blist);// list키이름에 목록 저장
		m.addAttribute("totalCount", totalCount);
		m.addAttribute("startpage",startpage);
		m.addAttribute("endpage",endpage);
		m.addAttribute("maxpage",maxpage);
		m.addAttribute("page",page);
		
		return "/board/freeboard/freeboard_list";
	} // freeboard_list()
	
	// 게시물 내용보기
	@RequestMapping("freeboard_cont")
	public ModelAndView freeboard_cont(@RequestParam("board_no")int board_no, @RequestParam("page")int page) {
		
		BoardVO bc = freeboardService.getFreeBoardCont(board_no);
		String cont = bc.getBoard_cont().replace("\n", "<br/>");
		
		ModelAndView cm = new ModelAndView();
		cm.addObject("b", bc);
		cm.addObject("cont", cont);
		cm.addObject("page", page);
		cm.setViewName("board/freeboard/freeboard_cont");
		return cm;
	} // freeboard_cont()
	
	// 게시물 수정
	@GetMapping("freeboard_edit")
	public String freeboard_edit(Model em, int board_no, int page) {
		
		BoardVO eb = this.freeboardService.getFreeBoardCont2(board_no);
		
		em.addAttribute("b", eb);
		em.addAttribute("page", page);
		return "board/freeboard/freeboard_edit";
	} // freeboard_edit()
	
	// 게시물 수정 완료
	@RequestMapping("freeboard_edit_ok")
	public ModelAndView freeboard_edit_ok(int board_no, int page, BoardVO eb) {
		freeboardService.editBoard(eb);
		
		ModelAndView em = new ModelAndView();
		em.setViewName("redirect:freeboard_cont");
		em.addObject("board_no", eb.getBoard_no());
		em.addObject("page", page);
		return em;
	} // freeboard_edit_ok()
	
	// 게시물 삭제
	@RequestMapping("/freeboard_del")
	public String freeboard_del(int board_no, int page, RedirectAttributes rttr) {
		this.freeboardService.delFreeBoard(board_no);
		
		rttr.addAttribute("msg", "SUCCESS");
		return "redirect:/freeboard_list?page="+page;
	}
	
	// 첨부파일
			
}



















