package com.assemble.dao;

import java.util.List;

import com.assemble.vo.ThemaVO;
import com.assemble.vo.WebtoonVO;
import com.assemble.vo.WishVO;

public interface ThemaDAO {

	void insertThema(ThemaVO tm);

	List<WebtoonVO> getWebtoonList(WebtoonVO wb);

	List<ThemaVO> getWebtoonList1(ThemaVO wb);

	Object deleteThema(String thema_title);

	List<WishVO> getWishList(WishVO wsb);

	List<WishVO> getWishList_male(WishVO wsb);

	List<WishVO> getWishList_female(WishVO wsb);

}
