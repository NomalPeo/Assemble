package com.assemble.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.stereotype.Repository;

import com.assemble.vo.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertReview(ReviewVO rv) {
		this.sqlSession.insert("review_in", rv);
	}

	@Override
	public List<ReviewVO> getReviewList(ReviewVO rv) {
		return this.sqlSession.selectList("rev_list", rv);
	}

	@Override
	public void del_review(int review_no) {
		this.sqlSession.delete("rev_del", review_no);
	}

	
}
