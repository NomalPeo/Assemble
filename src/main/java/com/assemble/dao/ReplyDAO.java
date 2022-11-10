package com.assemble.dao;

import java.util.List;

import com.assemble.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(ReplyVO vo);

	List<ReplyVO> listReply(int board_no);
	
	int getBoard_no(int board_reply_rno);

	void deleteReply(int board_reply_rno);

	void updateReply(ReplyVO vo);




}
