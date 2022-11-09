package com.assemble.service;

import java.util.List;

import com.assemble.vo.WishVO;

public interface WishService {

	List<WishVO> getWish(WishVO wl);

	void wish_ok(WishVO wo);

	void deleteWish(String wish_title);



	


}