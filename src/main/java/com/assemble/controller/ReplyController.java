package com.assemble.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assemble.service.ReplyService;
import com.assemble.vo.ReplyVO;

@RestController // 뷰 페이지를 만들지 않고도 원하는 문자열, xml, json타입 자료를 만들 수 있다.
@RequestMapping("/replies/*")
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	// 댓글 등록
	@PostMapping(value="/addreply",produces="application/json")
	public ResponseEntity<String> addReply(@RequestBody ReplyVO vo, Principal principal){
		
		ResponseEntity<String> entity = null;
		
		String board_reply_writer = principal.getName(); // 여기부터 
		System.out.println(board_reply_writer);
		vo.setBoard_reply_writer(board_reply_writer); // 여기까지
		
		try {
			this.replyService.insertReply(vo);
			entity=new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	} // addReply()
	
	// 댓글 목록
	@RequestMapping(value="/all/{board_no}",produces="application/json")
	public ResponseEntity<List<ReplyVO>> replyList(@PathVariable("board_no")int board_no){
		
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(this.replyService.listReply(board_no), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	} //replyList()
	
	//댓글 수정
		@RequestMapping(value="/{board_reply_rno}",method= {RequestMethod.PUT, RequestMethod.PATCH})
		//PUT은 전체자료 수정, PATCH는 일부 자료 수정
		public ResponseEntity<String> editReply(@PathVariable("board_reply_rno") int board_reply_rno, @RequestBody ReplyVO vo){
			ResponseEntity<String> entity=null;
			/* rno는 주소창에서 구해주는 댓글 번호이다.즉 json데이터가 아니다. 그러므로 @RequestBody에 의해서 JSON데이터가 ReplyVO
			 * 타입으로 변경안된다.코드로 따로 저장해야 한다.
			 */
			try {
				vo.setBoard_reply_rno(board_reply_rno);//댓글번호 따로 저장
				this.replyService.updateReply(vo);//댓글을 수정
				entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
			return entity;
		}//editReply()
	
	//댓글 삭제
	@RequestMapping(value="/{board_reply_rno}",method=RequestMethod.DELETE)
	//DELETE는 삭제
	public ResponseEntity<String> delReply(@PathVariable("board_reply_rno") int board_reply_rno){
		ResponseEntity<String> entity=null;
		
		try {
			replyService.deleteReply(board_reply_rno);//댓글 번호를 기준으로 삭제
			entity=new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}//delReply()
	
	
}
	












