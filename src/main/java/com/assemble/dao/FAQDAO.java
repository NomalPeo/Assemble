package com.assemble.dao;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface FAQDAO {

	void insertBoard(BoardVO b);

	int getTotalCount(BoardVO b);

	List<BoardVO> getBoardList(BoardVO b);

	void updateHit(int board_no);

	BoardVO getQnaBoardCont(int board_no);

	void editBoard(BoardVO eb);

	void delFreeBoard(int board_no);

	
}
