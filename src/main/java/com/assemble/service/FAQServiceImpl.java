package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.assemble.dao.FAQDAO;
import com.assemble.vo.BoardVO;

@Service
public class FAQServiceImpl implements FAQService {
	@Autowired
	private FAQDAO FAQDao;

	@Override
	public void insertBoard(BoardVO b) {
		this.FAQDao.insertBoard(b);
	}

	@Override
	public int getRowCount(BoardVO b) {
		return this.FAQDao.getTotalCount(b);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.FAQDao.getBoardList(b);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVO getqnaCont(int board_no) {
		this.FAQDao.updateHit(board_no);
		
		return FAQDao.getQnaBoardCont(board_no);
	}

	@Override
	public BoardVO getQnaBoardCont2(int board_no) {
		return this.getqnaCont(board_no);
	}

	@Override
	public void editBoard(BoardVO eb) {
		this.FAQDao.editBoard(eb);
	}

	@Override
	public void delqnaBoard(int board_no) {
		this.FAQDao.delFreeBoard(board_no);

	}



}
