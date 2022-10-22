package com.assemble.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.assemble.vo.UsersVO;

@Repository
public class UserMapperDAOImpl implements UserMapperDAO {
	@Inject
	private SqlSession sqlSession;

	@Override
	public UsersVO readUser(String username) {
		return this.sqlSession.selectOne("read_memInfo",username);

	}


}
