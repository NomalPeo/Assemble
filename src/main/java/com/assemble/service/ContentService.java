package com.assemble.service;

import java.util.List;

import com.assemble.vo.WebtoonVO;

public interface ContentService {

	WebtoonVO getContent(String webtoon_thumbnail);

	List<WebtoonVO> getContent2(WebtoonVO w);

}
