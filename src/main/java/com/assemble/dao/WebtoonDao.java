package com.assemble.dao;

import java.util.List;

import com.assemble.vo.WebtoonVO;

public interface WebtoonDao {

    void insertwebtoon(WebtoonVO wb);

    int getTotalCount(WebtoonVO wb);

    List<WebtoonVO> getWebtoonList(WebtoonVO wb);

    List<WebtoonVO> RomanceGetWebtoonlist1(WebtoonVO wb);

    List<WebtoonVO> RomanceGetWebtoonlist2(WebtoonVO wb);

    List<WebtoonVO> RomanceGetWebtoonlist3(WebtoonVO wb);

    List<WebtoonVO> RomanceGetWebtoonlist4(WebtoonVO wb);


    List<WebtoonVO> ThrillerWebtoonList1(WebtoonVO wb);

    List<WebtoonVO> ThrillerWebtoonList2(WebtoonVO wb);

    List<WebtoonVO> ThrillerWebtoonList3(WebtoonVO wb);

    List<WebtoonVO> ThrillerWebtoonList4(WebtoonVO wb);

    List<WebtoonVO> ActionWebtoonList1(WebtoonVO wb);

    List<WebtoonVO> ActionWebtoonList2(WebtoonVO wb);

    List<WebtoonVO> ActionWebtoonList3(WebtoonVO wb);

    List<WebtoonVO> ActionWebtoonList4(WebtoonVO wb);
}
