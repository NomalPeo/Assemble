package com.assemble.dao;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface AdminBoardDAO {

	List<BoardVO> getBoardList(BoardVO vo);

}
