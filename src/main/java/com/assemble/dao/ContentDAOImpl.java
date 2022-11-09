package com.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.WebtoonVO;

@Repository
public class ContentDAOImpl implements ContentDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public WebtoonVO getContent(String webtoon_thumbnail) {
		return this.sqlSession.selectOne("content", webtoon_thumbnail);
	}

	@Override
	public List<WebtoonVO> getContent2(WebtoonVO w) {
		return this.sqlSession.selectList("content2", w);
	}

	
}
