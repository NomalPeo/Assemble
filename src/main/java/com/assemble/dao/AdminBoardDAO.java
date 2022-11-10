package com.assemble.dao;

import java.util.List;

import com.assemble.vo.BoardVO;
import com.assemble.vo.ReplyVO;
import com.assemble.vo.UsersVO;

public interface AdminBoardDAO {

	List<BoardVO> getBoardList(BoardVO vo);

	int getRowCount();

	BoardVO getBoardCont(int board_no);

	void contentUpHit(int board_no);

	List<ReplyVO> ListReply(int board_no);

	void deleteReply(int board_rno);

	void AdminReplyInsert(ReplyVO vo);

	List<UsersVO> UserList(UsersVO vo);

	int getUserRowCount();

	void deleteUser(String user_no);

	void deleteUserAuth(String user_no);

	void boardDel(int board_no);

	void replyDel(int board_no);

	void insertNotice(BoardVO bv);


}
