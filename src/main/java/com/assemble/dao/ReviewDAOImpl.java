package com.assemble.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.assemble.vo.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertReview(ReviewVO r) {
		this.sqlSession.insert("review_in", r);
	}

}
