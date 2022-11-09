package com.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.WishVO;

@Repository
public class WishDAOImpl implements WishDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<WishVO> getWish(WishVO wl) {
		return this.sqlSession.selectList("w_list", wl);
	}

	@Override
	public void wish_ok(WishVO wo) {
		this.sqlSession.insert("w_in", wo);
	}

	@Override
	public void deleteWish(String wish_title) {
		this.sqlSession.delete("w_del", wish_title);
	}

	

}