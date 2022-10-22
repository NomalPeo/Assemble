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
/* UserDetailsService가 별도의 인증/권한 체크를 하는 이유는 JSP등에서 단순히 사용자 아이디(스프링 시큐리티에서는 username)가
 * 아닌 이메일이나 사용자 이름과 같은 추가적인 정보를 이용하기 위해서 이다.
 */
	public void setUserMapperDao(UserMapperDAO userMapperDao) {
		this.userMapperDao = userMapperDao;
	}
	

}
