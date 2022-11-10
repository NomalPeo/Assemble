package com.assemble.service;

import java.util.List;

import com.assemble.vo.ReplyVO;

public interface ReplyService {

	void insertReply(ReplyVO vo);

	List<ReplyVO> listReply(int board_no);

	void deleteReply(int board_reply_rno);

	void updateReply(ReplyVO vo);














}
