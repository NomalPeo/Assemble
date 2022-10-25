package com.assemble.dao;

import java.util.List;

import com.assemble.vo.WebtoonVO;

public interface WebtoonDao {

	void insertwebtoon(WebtoonVO wb);

	int getTotalCount(WebtoonVO wb);

	List<WebtoonVO> getWebtoonList(WebtoonVO wb);

}
