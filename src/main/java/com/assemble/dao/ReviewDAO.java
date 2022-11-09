package com.assemble.dao;



import java.util.List;

import com.assemble.vo.ReviewVO;

public interface ReviewDAO {

	void insertReview(ReviewVO rv);

	List<ReviewVO> getReviewList(ReviewVO rv);

	void del_review(int review_no);


}
