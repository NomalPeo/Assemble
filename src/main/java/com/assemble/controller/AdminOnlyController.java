package com.assemble.controller;

import java.io.File;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assemble.service.AdminBoardService;
import com.assemble.service.WebtoonService;
import com.assemble.vo.BoardVO;
import com.assemble.vo.ReplyVO;
import com.assemble.vo.UsersVO;
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
	public void adminPage(){}

	@RequestMapping("/boardmanager")
	public void boardmanager() {}
	

	@RequestMapping("/notice")
	public void notice() {}
	
	@GetMapping("/noticeWrite")
	public String noticeWrite(HttpServletRequest request,BoardVO bv, Principal principal) {
		String board_title = request.getParameter("board_title");
		String board_cont = request.getParameter("board_cont");
		String board_writer = principal.getName();
		bv.setBoard_title(board_title);
		bv.setBoard_cont(board_cont);
		bv.setBoard_writer(board_writer);
		this.adminBoardService.insertNotice(bv);
		
		return "redirect:/admin/adminPage";
	}
	
	@RequestMapping(value="/boardmanager1",produces="application/json")
	public ResponseEntity<List<BoardVO>> boardmanager(HttpServletRequest request, BoardVO vo ) {

		ResponseEntity<List<BoardVO>> entity=null;
		int type = 1;
		vo.setBoard_type(type);


		try {
			entity=new ResponseEntity<>(this.adminBoardService.getList(vo),
					HttpStatus.OK);//게시판 번호에 대한 댓글 목록

		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//FAQ/QNA
	@RequestMapping(value="/boardmanager2",produces="application/json")
	public ResponseEntity<List<BoardVO>> boardmanager2(HttpServletRequest request, BoardVO vo) {
		ResponseEntity<List<BoardVO>> entity=null;
		int type = 2;
		vo.setBoard_type(type);

		try {
			entity=new ResponseEntity<>(this.adminBoardService.getList(vo),
					HttpStatus.OK);//게시판 번호에 대한 댓글 목록
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//추천게시판
	@RequestMapping(value="/boardmanager3",produces="application/json")
	public ResponseEntity<List<BoardVO>> boardmanager3(HttpServletRequest request, BoardVO vo) {
		ResponseEntity<List<BoardVO>> entity=null;
		int type = 3;
		vo.setBoard_type(type);

		try {
			entity=new ResponseEntity<>(this.adminBoardService.getList(vo),
					HttpStatus.OK);//게시판 번호에 대한 댓글 목록
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//공지사항
	@RequestMapping(value="/boardmanager4",produces="application/json")
	public ResponseEntity<List<BoardVO>> boardmanager4(HttpServletRequest request, BoardVO vo) {
		ResponseEntity<List<BoardVO>> entity=null;
		int type = 4;
		vo.setBoard_type(type);

		try {
			entity=new ResponseEntity<>(this.adminBoardService.getList(vo),
					HttpStatus.OK);//게시판 번호에 대한 댓글 목록
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	//전체
	@RequestMapping(value="/boardmanager5",produces="application/json")
	public ResponseEntity<List<BoardVO>> boardmanager5(HttpServletRequest request, BoardVO vo) {
		ResponseEntity<List<BoardVO>> entity=null;
		try {
			entity=new ResponseEntity<>(this.adminBoardService.getList(vo),
					HttpStatus.OK);//게시판 번호에 대한 댓글 목록
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}


	@RequestMapping("/boardCorriger/{board_no}")
	public String boardCorriger(@PathVariable("board_no") int board_no, HttpServletRequest request, Model m) {
		this.adminBoardService.contentUpHit(board_no);
		BoardVO bc = adminBoardService.getBoardCont(board_no);
		int type_ =bc.getBoard_type();
		String type = "";
		if( type_ == 1) {
			type = "자유게시판";
		}else if(type_==2){
			type = "FAQ/QNA";
		}else if(type_==3) {
			type = "추천게시판";
		}else {
			type="공지사항";
		}
		String cont = bc.getBoard_cont().replace("\n", "<br/>");
		m.addAttribute("type", type);
		m.addAttribute("bc", bc);
		m.addAttribute("cont", cont);

		return "/admin/boardCorriger";
	}

	@RequestMapping(value="/boardReply/{board_no}",produces="application/json")
	public ResponseEntity<List<ReplyVO>> replyList(@PathVariable("board_no") int board_no){
		ResponseEntity<List<ReplyVO>> entity=null;

		try {
			entity=new ResponseEntity<>(this.adminBoardService.listReply(board_no),
					HttpStatus.OK);//게시판 번호에 대한 댓글 목록
			List<ReplyVO> list = entity.getBody();
			for(ReplyVO reply:list) {
				String date = reply.getBoard_regdate().substring(0,10);
				reply.setBoard_regdate(date);
			}
			entity = new ResponseEntity<>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	//댓글 삭제
	@RequestMapping(value="/boardDel/{board_rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delReply(@PathVariable("board_rno") int board_rno){
		ResponseEntity<String> entity=null;
		try {
			adminBoardService.deleteReply(board_rno);//댓글 번호를 기준으로 삭제
			entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}


	//유저삭제
	@RequestMapping(value="/userDel/{user_id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> userDel(@PathVariable("user_id") String user_id){
		ResponseEntity<String> entity=null;
		try {
			adminBoardService.deleteUserAuth(user_id);
			adminBoardService.deleteUser(user_id); // 유저 no 기준으로 삭제
			entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("boardDel1")
	public String boardDel1 (HttpServletRequest request) {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		this.adminBoardService.boardDel(board_no);
		return "redirect:/admin/boardmanager";
	}
	



	@PostMapping("/replyAdd1")
	public ResponseEntity<String> replyAdd1(@RequestBody ReplyVO vo,Principal principal){
		ResponseEntity<String> entity = null;
		String board_writer = principal.getName();
		System.out.println(board_writer);
		vo.setBoard_reply_writer(board_writer);
		try {
			this.adminBoardService.AdminReplyInsert(vo);
			entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			//예외 에러가 발생했을 때 에러 메시지와 나쁜 상태 코드 문자가 반환
		}
		return entity;
	}

	@RequestMapping("/webtooninsert")
	public String webtooninsert() {

		return "/admin/webtooninsert";
	}


	@RequestMapping(value="/webtooninsert1", method=RequestMethod.POST)
	public String webtooninsert(HttpServletRequest request, HttpServletResponse response, WebtoonVO wb) throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		String saveFolder = request.getRealPath("/resources/upload");
		System.out.println(saveFolder);
		int fileSize = 5 * 1024 * 1024; // 이진파일 업로드 최대크기(5M)

		MultipartRequest multi = null;

		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");

		String webtoon_title = multi.getParameter("webtoon_title");
		String webtoon_writer = multi.getParameter("webtoon_writer");
		String webtoon_age = multi.getParameter("webtoon_age");
		String webtoon_cont = multi.getParameter("webtoon_cont");
		String webtoon_tag1 = multi.getParameter("webtoon_tag1");
		String webtoon_tag2 = multi.getParameter("webtoon_tag2");
		String webtoon_complete = multi.getParameter("webtoon_complete");
		String webtoon_platform = multi.getParameter("webtoon_platform");
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
		return "redirect:/main";
	}


	@GetMapping("/user_manager")
	public String user_manager(UsersVO vo,Model m,Authentication auth,HttpServletRequest request) {
		int page=1;
		int limit=20;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		vo.setStartrow((page-1)*20+1);
		vo.setEndrow(vo.getStartrow()+limit-1);//끝행
		String find_name = request.getParameter("find_name");
		String find_field = request.getParameter("find_field");
		vo.setFind_field(find_field);
		vo.setFind_name("%" + find_name + "%");

		int totalCount=this.adminBoardService.getUserRowCount();
		List<UsersVO> uList = this.adminBoardService.UserList(vo);

		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		int maxpage=(int)((double)totalCount/limit+0.95);
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		int endpage=maxpage;
		if(endpage > startpage+10-1) endpage=startpage+10-1;
		m.addAttribute("totalCount",totalCount);
		m.addAttribute("startpage",startpage);
		m.addAttribute("endpage",endpage);
		m.addAttribute("maxpage",maxpage);
		m.addAttribute("page",page);
		m.addAttribute("uList", uList);
		m.addAttribute("find_field", find_field);
		m.addAttribute("find_name", find_name);
		return "/admin/user_manager";
	}

	
















}
