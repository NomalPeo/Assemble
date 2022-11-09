package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assemble.dao.AdminBoardDAO;
import com.assemble.vo.BoardVO;
import com.assemble.vo.ReplyVO;
import com.assemble.vo.UsersVO;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {
	
	@Autowired
	private AdminBoardDAO adminBoardDao;
	
	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return adminBoardDao.getBoardList(vo);
	}

	@Override
	public int getRowCount() {
		return this.adminBoardDao.getRowCount();
	}

	@Override
	public BoardVO getBoardCont(int board_no) {
		return this.adminBoardDao.getBoardCont(board_no);
	}

	@Transactional
	@Override
	public void contentUpHit(int board_no) {
		this.adminBoardDao.contentUpHit(board_no);
	}

	@Override
	public List<ReplyVO> listReply(int board_no) {
		return this.adminBoardDao.ListReply(board_no);
	}
	
	@Transactional
	@Override
	public void deleteReply(int board_rno) {
		this.adminBoardDao.deleteReply(board_rno);
	}
	
	@Transactional //트랜적용 적용
	@Override
	public void AdminReplyInsert(ReplyVO vo) {
		this.adminBoardDao.AdminReplyInsert(vo);
	}

	@Override
	public List<UsersVO> UserList(UsersVO vo) {
		return this.adminBoardDao.UserList(vo);
	}

	@Override
	public int getUserRowCount() {
		return this.adminBoardDao.getUserRowCount();
	}

	@Transactional //트랜적용 적용
	@Override
	public void deleteUser(String user_no) {
		this.adminBoardDao.deleteUser(user_no);
	}

	@Transactional
	@Override
	public void deleteUserAuth(String user_no) {
		this.adminBoardDao.deleteUserAuth(user_no);
	}


	
	
	
	
}
