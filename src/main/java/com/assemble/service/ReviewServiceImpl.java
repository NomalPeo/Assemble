package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.ReviewDAO;
import com.assemble.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDao;

	@Override
	public void insertReview(ReviewVO rv) {
		this.reviewDao.insertReview(rv);
	}

	@Override
	public List<ReviewVO> getReviewList(ReviewVO rv) {
		return this.reviewDao.getReviewList(rv);
	}

	@Override
	public void del_review(int review_no) {
		this.reviewDao.del_review(review_no);
	}

}
