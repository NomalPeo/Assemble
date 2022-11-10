package com.assemble.service;

import java.util.List;

import com.assemble.vo.BoardVO;
import com.assemble.vo.ReplyVO;

public interface FreeBoardService {

	void insertBoard(BoardVO b);

	List<BoardVO> getBoardList(BoardVO b);


	BoardVO getFreeBoardCont(int board_no);

	BoardVO getFreeBoardCont2(int board_no);

	void editBoard(BoardVO eb);

	void delFreeBoard(int board_no);
	
	/*아래부터 검색관련*/
	int getRowCount(BoardVO b);


	

}
