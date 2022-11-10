package com.assemble.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Calendar;
import java.util.List;/*게시판목록*/
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; /*게시판목록*/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.FreeBoardService;
import com.assemble.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;

import oracle.net.aso.l;

@Controller
public class FreeBoardController {
	
	@Autowired
	private FreeBoardService freeboardService;
	
	// 회원만 게시판 글쓰기
		@RequestMapping(value="/freeboard_write", method=RequestMethod.GET)
		public ModelAndView freeboard_write(HttpServletRequest request, HttpServletResponse response, 
				Principal principal) throws Exception {
			
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			try {
				PrintWriter out = response.getWriter();
				String id = principal.getName();
				if(id == null) {
					out.println("<script>");
					out.println("alert('로그인이 필요한 서비스 입니다.');");
					out.println("location='freeboard_list';");
					out.println("</script>");
				}else {
					int page=1;
					if(request.getParameter("page")!=null){
						page=Integer.parseInt(request.getParameter("page"));
					}
					ModelAndView wm = new ModelAndView("board/freeboard_write");
					wm.addObject("page", page);
					return wm;
				}
				
			}catch(Exception e) {
				
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인이 필요한 서비스 입니다.');");
				out.println("location='freeboard_list';");
				out.println("</script>");
			}
			return null;
		}// freeboard_write()
	
	// 게시판 저장
	@RequestMapping(value="/freeboard_write",method=RequestMethod.POST)
	public ModelAndView freeboard_write_ok(BoardVO b, Principal principal, /*파일첨부->*/ HttpServletRequest request/*<-*/, RedirectAttributes rttr) throws IOException {
		// 여기부터 첨부파일 코드
		String saveFolder=request.getRealPath("/resources/upload");
		//이진파일 업로드 서버경로
		int fileSize=5*1024*1024; //이진파일 업로드 최대크기
		MultipartRequest multi=null; //이진파일을 받을 참조변수
		// 아래로 아이디 가져오기
		String board_writer = principal.getName();
		System.out.println(board_writer);
		b.setBoard_writer(board_writer); // <- 여기까지
		
		multi = new MultipartRequest(request,saveFolder,fileSize,"UTF-8");
		// String bbs_name = multi.getParameter("bbs_name");
		// String bbs_pwd = multi.getParameter("bbs_pwd");
		String board_title=multi.getParameter("board_title");
		String board_cont=multi.getParameter("board_cont");
		
		File UpFile=multi.getFile("board_file"); // 첨부한 이진파일을 받아옴
		
		if(UpFile != null) {
			String fileName = UpFile.getName();
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int date = c.get(Calendar.DATE);
			String homedir = saveFolder+"/"+year+"-"+month+"-"+date; //오늘 날짜 폴더 경로에 저장
			
			File path1 = new File(homedir);
			if(!(path1.exists())) {
				path1.mkdir(); // 오늘날짜 폴더경로를 생성
			}
			Random r = new Random();
			int random = r.nextInt(100000000);
			
			/*첨부파일 확장자를 구함*/
			int index = fileName.lastIndexOf("."); // 마침표 위치 번호를 구함
			String fileExtension = fileName.substring(index+1); // 마침표 이후부터 마지막 문자까지 구함. 첨부파일 확장자를 구함.
			String refileName = "board" + year + month + date + random + "." + fileExtension;
			String fileDBName="/" + year + "-" + month + "-" + date + "/" + refileName; // 디비에 저장될 레코드 값
			UpFile.renameTo(new File(homedir + "/" + refileName));
			// 바뀌어진 이진파일로 업로드
			b.setBoard_image(fileDBName);
		}else {
			String fileDBName="";
			b.setBoard_image(fileDBName);
		}
		//b.setBbs_name(bbs_name);
		//b.setBbs_pwd(bbs_pwd);
		b.setBoard_title(board_title);
		b.setBoard_cont(board_cont);
		
		try {
			this.freeboardService.insertBoard(b);
			rttr.addFlashAttribute("msg","SUCCESS");
		}catch(Exception e) {
			e.printStackTrace();
			ResponseEntity entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		/*아래 두줄은 기존코드*/
		return new ModelAndView("redirect:/freeboard_list");
	} // freeboard_write_ok()
	
	// 게시판 목록
	@GetMapping("freeboard_list")
	public String freeboard_list(Model m, BoardVO b, HttpServletRequest request) {
		
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
		
		int listcount = this.freeboardService.getRowCount(b);
		// 전체 레코드 개수 또는 검색전후 레코드 개수
		/*윗줄 까지*/
		
		b.setStartrow((page-1)*20+1);
		b.setEndrow(b.getStartrow()+limit-1);
		
		List<BoardVO> blist=this.freeboardService.getBoardList(b);
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
		
		return "/board/freeboard_list";
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
		cm.setViewName("board/freeboard_cont2");
		
		return cm;
	} // freeboard_cont()
	
	// 게시물 수정
	@GetMapping("freeboard_edit")
	public String freeboard_edit(Model em, int board_no, int page,String board_writer,
			Principal principal,HttpServletResponse response, HttpServletRequest request,Authentication auth) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			String id = auth.getName();
			if(id == null) {
				out.println("<script>");
				out.println("alert('로그인이 필요한 서비스 입니다.');");
				out.println("location='freeboard_list';");
				out.println("</script>");
			}else {
				if(id.equals(board_writer)) {
					BoardVO eb = this.freeboardService.getFreeBoardCont2(board_no);
					em.addAttribute("b", eb);
					em.addAttribute("page", page);
					return "/board/freeboard_edit";
				}else {
					out.println("<script>");
					out.println("alert('수정할 수 없습니다.');");
					out.println("history.back();");
					out.println("</script>");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
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
	public String freeboard_del(String board_writer,int board_no, int page, RedirectAttributes rttr,
			Principal principal, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String writer = principal.getName();
		try {
			if(board_writer.equals(writer)) {
				this.freeboardService.delFreeBoard(board_no);
				out.println("<script>");
				out.println("alert('글삭제.');");
				out.println("location='/freeboard_list';");
				out.println("</script>");
			}else {
				rttr.addAttribute("msg", "SUCCESS");
				out.println("<script>");
				out.println("alert('글을 삭제할 수 없습니다..');");
				out.println("history.back();");
				out.println("</script>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
