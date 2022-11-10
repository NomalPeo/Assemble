package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assemble.dao.FreeBoardDAO;
import com.assemble.dao.ReplyDAO;
import com.assemble.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	
	@Autowired
	private FreeBoardDAO freeboardDao;

	@Transactional
	@Override
	public void insertReply(ReplyVO vo) {
		replyDao.insertReply(vo);
		/*this.freeboardDao.updateReplyCnt(vo.getBoard_no(),1);*/ // 게시판 번호를 구해서 댓글 개수 1 증가
	}// 댓글이 추가되면 댓글 카운터 1증가

	@Override
	public List<ReplyVO> listReply(int board_no) {
		return this.replyDao.listReply(board_no);
	}
	
	@Transactional
	@Override
	public void deleteReply(int board_reply_rno) {
		/*int board_no = this.replyDao.getBoard_no(board_reply_rno);*/
		this.replyDao.deleteReply(board_reply_rno);
		/*this.freeboardDao.updateReplyCnt(board_no, -1);*/
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);
	}

}
