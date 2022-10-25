package com.assemble.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.assemble.vo.BoardVO;

@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("fb_in", b);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.sqlSession.selectList("fb_list",b);
	}

	@Override
	public int getRowCount() {
		return this.sqlSession.selectOne("fb_count");
	}


	@Override
	public BoardVO getFreeBoardCont(int board_no) {
		return this.sqlSession.selectOne("fb_cont", board_no);
	}

	@Override
	public void updateHit(int board_no) {
		this.sqlSession.update("fb_hit",board_no);
		
	}

	@Override
	public void editBoard(BoardVO eb) {
		this.sqlSession.update("fb_edit", eb);
		
	}

	@Override
	public void delFreeBoard(int board_no) {
		this.sqlSession.delete("fb_del", board_no);
	}



	
	
	


}
