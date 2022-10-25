package com.assemble.dao;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface FreeBoardDAO {

	void insertBoard(BoardVO b);

	List<BoardVO> getBoardList(BoardVO b);

	int getRowCount();

	BoardVO getFreeBoardCont(int board_no);

	void updateHit(int board_no);

	void editBoard(BoardVO eb);

	void delFreeBoard(int board_no);


}
