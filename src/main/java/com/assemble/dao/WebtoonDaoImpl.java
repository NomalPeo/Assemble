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
      return this.sqlSession.selectList("web_list", wb);
   }
}