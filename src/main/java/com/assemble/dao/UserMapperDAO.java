package com.assemble.dao;

import com.assemble.vo.UsersVO;

public interface UserMapperDAO {

	UsersVO readUser(String login_id);

}
