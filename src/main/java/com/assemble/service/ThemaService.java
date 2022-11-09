package com.assemble.service;

import java.util.List;

import com.assemble.vo.ThemaVO;
import com.assemble.vo.WebtoonVO;
import com.assemble.vo.WishVO;

public interface ThemaService {

	void insertThema(ThemaVO tm);

	List<WebtoonVO> getWebtoonList(WebtoonVO wb);

	List<ThemaVO> getWebtoonList1(ThemaVO tb);

	void deleteThema(String thema_title);

	List<WishVO> getWishList(WishVO wsb);

	List<WishVO> getWishList_male(WishVO wsb);

	List<WishVO> getWishList_female(WishVO wsb);

}
