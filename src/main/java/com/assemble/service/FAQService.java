package com.assemble.service;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface FAQService {

	void insertBoard(BoardVO b);

	int getRowCount(BoardVO b);

	List<BoardVO> getBoardList(BoardVO b);

	BoardVO getqnaCont(int board_no);

	BoardVO getQnaBoardCont2(int board_no);

	void editBoard(BoardVO eb);

	void delqnaBoard(int board_no);




}
