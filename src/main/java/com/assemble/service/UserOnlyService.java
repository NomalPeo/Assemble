package com.assemble.service;

import com.assemble.vo.UsersVO;

public interface UserOnlyService {

    UsersVO getUsers(String id);

    void delUser(UsersVO dm);

    void authDel(String user_id);

	void updateUserSecurity(UsersVO vo);

	String getUserPwd(String user_id);

	void updateUserPwd(UsersVO uv);


}
