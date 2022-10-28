package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.WebtoonDao;
import com.assemble.vo.WebtoonVO;

@Service
public class WebtoonServiceImpl implements WebtoonService {
	@Autowired
	private WebtoonDao webtoonDao;

	@Override
	public void insertwebtoon(WebtoonVO wb) {
		this.webtoonDao.insertwebtoon(wb);
	}

	@Override
	public int getListCount(WebtoonVO wb) {
		return webtoonDao.getTotalCount(wb);
	}

	@Override
	public List<WebtoonVO> getWebtoonList(WebtoonVO wb) {
		return webtoonDao.getWebtoonList(wb);
	}

	@Override
	public List<WebtoonVO> RomanceGetWebtoonList1(WebtoonVO wb) {
		return this.webtoonDao.RomanceGetWebtoonlist4(wb);
	}

	@Override
	public List<WebtoonVO> RomanceGetWebtoonList2(WebtoonVO wb) {
		return this.webtoonDao.RomanceGetWebtoonlist1(wb);
	}
	@Override
	public List<WebtoonVO> RomanceGetWebtoonList3(WebtoonVO wb) {
		return this.webtoonDao.RomanceGetWebtoonlist2(wb);
	}
	@Override
	public List<WebtoonVO> RomanceGetWebtoonList4(WebtoonVO wb) {
		return this.webtoonDao.RomanceGetWebtoonlist3(wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList1(WebtoonVO wb) {
		return this.webtoonDao.ThrillerWebtoonList1(wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList2(WebtoonVO wb) {
		return this.webtoonDao.ThrillerWebtoonList2(wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList3(WebtoonVO wb) {
		return this.webtoonDao.ThrillerWebtoonList3(wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList4(WebtoonVO wb) {
		return this.webtoonDao.ThrillerWebtoonList4(wb);
	}

	@Override
	public List<WebtoonVO> ActionWebtoonList1(WebtoonVO wb) {
		return this.webtoonDao.ActionWebtoonList1(wb);
	}

	@Override
	public List<WebtoonVO> ActionWebtoonList2(WebtoonVO wb) {
		return this.webtoonDao.ActionWebtoonList2(wb);
	}

	@Override
	public List<WebtoonVO> ActionWebtoonList3(WebtoonVO wb) {
		return this.webtoonDao.ActionWebtoonList3(wb);
	}

	@Override
	public List<WebtoonVO> ActionWebtoonList4(WebtoonVO wb) {
		return this.webtoonDao.ActionWebtoonList4(wb);
	}

}
