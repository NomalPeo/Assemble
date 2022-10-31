package com.assemble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.AdminBoardDAO;
import com.assemble.vo.BoardVO;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {
	
	@Autowired
	private AdminBoardDAO adminBoardDao;
	
	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return adminBoardDao.getBoardList(vo);
	}
	
	
	
	
	
}
