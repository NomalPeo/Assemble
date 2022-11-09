package com.assemble.service;

import com.assemble.vo.UsersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assemble.dao.UserOnlyDAO;

@Service
public class UserOnlyServiceImpl implements UserOnlyService {
	@Autowired
	private UserOnlyDAO userOnlyDao;

	@Override
	public UsersVO getUsers(String id) {
		return this.userOnlyDao.getUsers(id);
	}

	@Override
	public void delUser(UsersVO dm) {
		this.userOnlyDao.delUser(dm);
	}
	@Override
	public void authDel(String user_id) {
		this.userOnlyDao.authDel(user_id);
	}

	@Override
	public void updateUserSecurity(UsersVO vo) {
		this.userOnlyDao.updateUserSecurity(vo);
	}

	@Override
	public String getUserPwd(String user_id) {
		return this.userOnlyDao.getUserPwd(user_id);
	}

	@Override
	public void updateUserPwd(UsersVO uv) {
		this.userOnlyDao.updateUserPwd(uv);
	}

}
