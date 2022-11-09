package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.WishDAO;
import com.assemble.vo.WishVO;

@Service
public class WishServiceImpl implements WishService {

	@Autowired
	private WishDAO wishDAO;

	@Override
	public List<WishVO> getWish(WishVO wl) {
		return this.wishDAO.getWish(wl);
	}

	@Override
	public void wish_ok(WishVO wo) {
		this.wishDAO.wish_ok(wo);
	}

	@Override
	public void deleteWish(String wish_title) {
		this.wishDAO.deleteWish(wish_title);
	}

	

	

}