package com.assemble.service;

import java.util.List;

import com.assemble.vo.WebtoonVO;

public interface WebtoonService {

	void insertwebtoon(WebtoonVO wb);

	int getListCount(WebtoonVO wb);

	List<WebtoonVO> getWebtoonList(WebtoonVO wb);

}
