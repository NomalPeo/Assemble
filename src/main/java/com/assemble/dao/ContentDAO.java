package com.assemble.dao;

import java.util.List;

import com.assemble.vo.WebtoonVO;

public interface ContentDAO {

	WebtoonVO getContent(String webtoon_thumbnail);

	List<WebtoonVO> getContent2(WebtoonVO w);

}
