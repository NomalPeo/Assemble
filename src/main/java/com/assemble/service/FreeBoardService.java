package com.assemble.service;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface FreeBoardService {

	void insertBoard(BoardVO b);

	List<BoardVO> getBoardList(BoardVO b);

	int getRowCount();

	BoardVO getFreeBoardCont(int board_no);

	BoardVO getFreeBoardCont2(int board_no);

	void editBoard(BoardVO eb);

	void delFreeBoard(int board_no);

	

}
