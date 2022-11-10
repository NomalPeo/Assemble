package com.assemble.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.BoardVO;
import com.assemble.vo.ReplyVO;
import com.assemble.vo.UsersVO;

@Repository
public class AdminBoardDAOImpl implements AdminBoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return sqlSession.selectList("adminBoard_List", vo);
	}

	@Override
	public int getRowCount() {
		return this.sqlSession.selectOne("board_c");
	}

	@Override
	public BoardVO getBoardCont(int board_no) {
		return this.sqlSession.selectOne("admin_board", board_no);
	}

	@Override
	public void contentUpHit(int board_no) {
		this.sqlSession.update("content_hit", board_no);
	}

	@Override
	public List<ReplyVO> ListReply(int board_no) {
		return this.sqlSession.selectList("adminBoard_reply", board_no);
	}

	@Override
	public void deleteReply(int board_rno) {
		this.sqlSession.delete("adminReply_del", board_rno);
	}

	@Override
	public void AdminReplyInsert(ReplyVO vo) {
		this.sqlSession.insert("admin_reply_insert", vo);
	}

	@Override
	public List<UsersVO> UserList(UsersVO vo) {
	return this.sqlSession.selectList("admin_user_list", vo);
	}

	@Override
	public int getUserRowCount() {
		return this.sqlSession.selectOne("admin_user_count");
	}

	@Override
	public void deleteUser(String user_no) {
		this.sqlSession.delete("admin_user_del", user_no);
	}

	@Override
	public void deleteUserAuth(String user_no) {
		this.sqlSession.delete("admin_user_auth_del", user_no);
	}

	@Override
	public void boardDel(int board_no) {
		this.sqlSession.delete("admin_board_del", board_no);
	}

	@Override
	public void replyDel(int board_no) {
		this.sqlSession.delete("admin_reply_del", board_no);
	}

	@Override
	public void insertNotice(BoardVO bv) {
		this.sqlSession.insert("admin_notice_in", bv);
	}


}
