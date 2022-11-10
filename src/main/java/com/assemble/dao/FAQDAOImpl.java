package com.assemble.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.assemble.vo.BoardVO;

@Repository
public class FAQDAOImpl implements FAQDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("qna_in", b);
	}

	@Override
	public int getTotalCount(BoardVO b) {
		return this.sqlSession.selectOne("qna_row", b);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.sqlSession.selectList("qna_list", b);
	}

	@Override
	public void updateHit(int board_no) {
		this.sqlSession.update("qna_hit",board_no);
	}

	@Override
	public BoardVO getQnaBoardCont(int board_no) {
		return this.sqlSession.selectOne("qna_cont", board_no);
	}

	@Override
	public void editBoard(BoardVO eb) {
		this.sqlSession.update("qna_edit", eb);
	}

	@Override
	public void delFreeBoard(int board_no) {
		this.sqlSession.delete("qna_del", board_no);
	}


}
