package com.assemble.dao;

import java.util.List;

import com.assemble.vo.BoardVO;

public interface FreeBoardDAO {

	void insertBoard(BoardVO b);

	List<BoardVO> getBoardList(BoardVO b);

	BoardVO getFreeBoardCont(int board_no);

	void updateHit(int board_no);

	void editBoard(BoardVO eb);

	void delFreeBoard(int board_no);

	void updateReplyCnt(int board_no, int count);

	/*아래부터 검색관련*/
	int getTotalCount(BoardVO b);


}
