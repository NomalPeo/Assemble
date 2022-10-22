package com.assemble.service;

import com.assemble.vo.UsersVO;

public interface UsersService {

	UsersVO idCheck(String id);

	void insertUsers(UsersVO m);

	UsersVO pwdUsers(UsersVO m);

	void updatePwd(UsersVO m);

	UsersVO loginCheck(String login_id);

	void authinsertUsers(String string);

}
