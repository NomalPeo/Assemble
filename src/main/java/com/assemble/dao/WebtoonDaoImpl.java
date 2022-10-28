package com.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.WebtoonVO;

@Repository
public class WebtoonDaoImpl implements WebtoonDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertwebtoon(WebtoonVO wb) {
		this.sqlSession.insert("web_in", wb);
	}

	@Override
	public int getTotalCount(WebtoonVO wb) {
		return this.sqlSession.selectOne("web_count", wb);
	}

	@Override
	public List<WebtoonVO> getWebtoonList(WebtoonVO wb) {
		System.out.println("인서트1");
		return this.sqlSession.selectList("web_list", wb);
		
	}

	@Override
	public List<WebtoonVO> RomanceGetWebtoonlist1(WebtoonVO wb) {
		return this.sqlSession.selectList("romanceW1", wb);
	}

	@Override
	public List<WebtoonVO> RomanceGetWebtoonlist2(WebtoonVO wb) {
		return this.sqlSession.selectList("romanceW2", wb);
	}

	@Override
	public List<WebtoonVO> RomanceGetWebtoonlist3(WebtoonVO wb) {
		return this.sqlSession.selectList("romanceW3", wb);
	}

	@Override
	public List<WebtoonVO> RomanceGetWebtoonlist4(WebtoonVO wb) {
		return this.sqlSession.selectList("romanceW4", wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList1(WebtoonVO wb) {
		return this.sqlSession.selectList("thrillerW1",wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList2(WebtoonVO wb) {
		return this.sqlSession.selectList("thrillerW2",wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList3(WebtoonVO wb) {
		return this.sqlSession.selectList("thrillerW3",wb);
	}

	@Override
	public List<WebtoonVO> ThrillerWebtoonList4(WebtoonVO wb) {
		return this.sqlSession.selectList("thrillerW4",wb);
	}

	@Override
	public List<WebtoonVO> ActionWebtoonList1(WebtoonVO wb) {
		return this.sqlSession.selectList("actionW1",wb);
	}

	@Override
	public List<WebtoonVO> ActionWebtoonList2(WebtoonVO wb) {
		return this.sqlSession.selectList("actionW2",wb);	}

	@Override
	public List<WebtoonVO> ActionWebtoonList3(WebtoonVO wb) {
		return this.sqlSession.selectList("actionW3",wb);	}

	@Override
	public List<WebtoonVO> ActionWebtoonList4(WebtoonVO wb) {
		return this.sqlSession.selectList("actionW4",wb);	}


}