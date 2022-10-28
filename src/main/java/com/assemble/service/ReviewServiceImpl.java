package com.assemble.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.ReviewDAO;
import com.assemble.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDao;

	@Override
	public void insertReview(ReviewVO r) {
			this.reviewDao.insertReview(r);
	}

}
