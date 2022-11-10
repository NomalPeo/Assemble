package com.assemble.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return this.sqlSession.selectList("fb_list", b);
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

	@Override
	public void updateReplyCnt(int board_no, int count) {
		Map<String,Object> cm = new HashMap<>();
		cm.put("board_no", board_no);
		cm.put("count", count);
		
		this.sqlSession.update("updateReplyCnt",cm);
	}

	/*아래부터 검색관련*/
	@Override
	public int getTotalCount(BoardVO b) {
		return this.sqlSession.selectOne("fb_row", b);
	} // 검색 전후 레코드 개수

}
