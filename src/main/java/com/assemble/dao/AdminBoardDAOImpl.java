package com.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.BoardVO;

@Repository
public class AdminBoardDAOImpl implements AdminBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return sqlSession.selectList("adminBoard_List", vo);
	}
}
