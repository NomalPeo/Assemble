package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.ThemaDAO;
import com.assemble.vo.ThemaVO;
import com.assemble.vo.WebtoonVO;
import com.assemble.vo.WishVO;

@Service
public class ThemaServiceImpl implements ThemaService {

	@Autowired
	private ThemaDAO themaDao;

	@Override
	public void insertThema(ThemaVO tm) {
		this.themaDao.insertThema(tm);
	}

	
	@Override
	public List<WebtoonVO> getWebtoonList(WebtoonVO wb) {
		return this.themaDao.getWebtoonList(wb);
	}


	@Override
	public List<ThemaVO> getWebtoonList1(ThemaVO tb) {
		return this.themaDao.getWebtoonList1(tb);
	}


	@Override
	public void deleteThema(String thema_title) {
		this.themaDao.deleteThema(thema_title);
	}


	@Override
	public List<WishVO> getWishList(WishVO wsb) {
		return this.themaDao.getWishList(wsb);
	}


	@Override
	public List<WishVO> getWishList_male(WishVO wsb) {
		return this.themaDao.getWishList_male(wsb);
	}


	@Override
	public List<WishVO> getWishList_female(WishVO wsb) {
		return this.themaDao.getWishList_female(wsb);
	}

}
