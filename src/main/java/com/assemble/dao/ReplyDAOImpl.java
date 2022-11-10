package com.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertReply(ReplyVO vo) {
		this.sqlSession.insert("r_in",vo);
	}// 댓글 저장

	@Override
	public List<ReplyVO> listReply(int board_no) {
		return this.sqlSession.selectList("r_list", board_no);
	}// 댓글목록

	@Override
	public int getBoard_no(int board_reply_rno) {
		return this.sqlSession.selectOne("reply_bno", board_reply_rno);
	}

	@Override
	public void deleteReply(int board_reply_rno) {
		this.sqlSession.delete("r_del", board_reply_rno);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlSession.update("r_edit",vo);
	}







}
