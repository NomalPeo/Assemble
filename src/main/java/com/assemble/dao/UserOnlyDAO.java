package com.assemble.dao;

import com.assemble.vo.UsersVO;

public interface UserOnlyDAO {

    UsersVO getUsers(String id);

    void delUser(UsersVO dm);

    void authDel(String user_id);

	void updateUserSecurity(UsersVO vo);

	String getUserPwd(String user_id);

	void updateUserPwd(UsersVO uv);


    
}
