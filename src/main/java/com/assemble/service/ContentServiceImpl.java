package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.ContentDAO;
import com.assemble.vo.WebtoonVO;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentDAO ContentDao;

	@Override
	public WebtoonVO getContent(String webtoon_thumbnail) {
		return this.ContentDao.getContent(webtoon_thumbnail);
	}

	@Override
	public List<WebtoonVO> getContent2(WebtoonVO w) {
		return this.ContentDao.getContent2(w);
	}

}
