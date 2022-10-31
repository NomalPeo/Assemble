package com.assemble.service;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface AdminBoardService {

	List<BoardVO> getList(BoardVO vo);

}
