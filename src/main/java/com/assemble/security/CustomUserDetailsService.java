package com.assemble.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.assemble.dao.UserMapperDAO;
import com.assemble.security.domain.CustomUser;
import com.assemble.vo.UsersVO;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	public UserMapperDAO userMapperDao;
	
	@Override
	public UserDetails loadUserByUsername(String login_id) 
			throws UsernameNotFoundException {
		System.out.println("Load User By UserName : " + login_id);
		UsersVO vo = this.userMapperDao.readUser(login_id);

		return (vo==null)?null:new CustomUser(vo);
	}
	public void setUserMapperDao(UserMapperDAO userMapperDao) {
		this.userMapperDao = userMapperDao;
	}
	

}
