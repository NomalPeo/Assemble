package com.assemble.service;

import java.util.List;

import com.assemble.vo.WebtoonVO;

public interface WebtoonService {

	void insertwebtoon(WebtoonVO wb);

	int getListCount(WebtoonVO wb);

	List<WebtoonVO> getWebtoonList(WebtoonVO wb);

	List<WebtoonVO> RomanceGetWebtoonList1(WebtoonVO wb);

	List<WebtoonVO> RomanceGetWebtoonList2(WebtoonVO wb);

	List<WebtoonVO> RomanceGetWebtoonList3(WebtoonVO wb);

	List<WebtoonVO> RomanceGetWebtoonList4(WebtoonVO wb);

    List<WebtoonVO> ThrillerWebtoonList1(WebtoonVO wb);

	List<WebtoonVO> ThrillerWebtoonList2(WebtoonVO wb);

	List<WebtoonVO> ThrillerWebtoonList3(WebtoonVO wb);

	List<WebtoonVO> ThrillerWebtoonList4(WebtoonVO wb);

	List<WebtoonVO> ActionWebtoonList1(WebtoonVO wb);

	List<WebtoonVO> ActionWebtoonList2(WebtoonVO wb);

	List<WebtoonVO> ActionWebtoonList3(WebtoonVO wb);

	List<WebtoonVO> ActionWebtoonList4(WebtoonVO wb);
}

