package com.assemble.dao;

import com.assemble.vo.UsersVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository	
public class UserOnlyDAOImpl implements UserOnlyDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UsersVO getUsers(String id) {
		return this.sqlSession.selectOne("m_edit", id);
	}


	@Override
	public void delUser(UsersVO dm) {
		this.sqlSession.delete("m_del", dm);
	}

	@Override
	public void authDel(String user_id) {
		this.sqlSession.delete("auth_del", user_id);
	}


	@Override
	public void updateUserSecurity(UsersVO vo) {
		this.sqlSession.update("user_security_edit", vo);
	}


	@Override
	public String getUserPwd(String user_id) {
		return this.sqlSession.selectOne("getUserPwd", user_id);
	}


	@Override
	public void updateUserPwd(UsersVO uv) {
		this.sqlSession.update("updateUserPwd", uv);
	}


}
