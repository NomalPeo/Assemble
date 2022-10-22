package com.assemble.dao;

import com.assemble.vo.UsersVO;

public interface UsersDAO {

	UsersVO idCheck(String id);

	void insertUsers(UsersVO m);

	UsersVO pwdUsers(UsersVO m);

	void updatePwd(UsersVO m);

	UsersVO loginCheck(String login_id);

	void authinsertUser(String string);

}
