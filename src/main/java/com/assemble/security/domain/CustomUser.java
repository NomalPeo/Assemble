package com.assemble.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.assemble.vo.UsersVO;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	
	
	private UsersVO user;
	
	public CustomUser(UsersVO vo) {
		super(vo.getUser_id(),vo.getUser_pwd(),vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		
		this.user=vo;
	}
	public CustomUser(String login_id, String login_pwd, Collection<? extends GrantedAuthority> 
	authorities) {
	
		super(login_id, login_pwd,authorities);
	}
}