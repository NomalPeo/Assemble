package com.assemble.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assemble.vo.UsersVO;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public UsersVO idCheck(String id) {
		return this.sqlSession.selectOne("id_check", id);
	}

	@Override
	public void insertUsers(UsersVO m) {
		this.sqlSession.insert("m_in", m);
	}

	@Override
	public UsersVO pwdUsers(UsersVO m) {
		return this.sqlSession.selectOne("p_find", m);
	}

	@Override
	public void updatePwd(UsersVO m) {
		this.sqlSession.update("p_edit", m);
	}

	@Override
	public UsersVO loginCheck(String login_id) {
		return this.sqlSession.selectOne("login_ck", login_id);
	}

	@Override
	public void authinsertUser(String string) {
		this.sqlSession.insert("auth_in", string);
	}
}
