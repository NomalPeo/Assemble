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
}
