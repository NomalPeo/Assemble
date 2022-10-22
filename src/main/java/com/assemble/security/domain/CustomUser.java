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
		/* 검색된 아아디, 비번, 권한정보를 람다식으로 목록을 수집한 다음 생성자를 호출해서 값을 전달하고 
		 * 객체화 한다. 부모 User의 오버로딩 된 생성자를 호출하면 인자값을 전달한다.
		 */
		
		this.user=vo;
	}
	public CustomUser(String login_id, String login_pwd, Collection<? extends GrantedAuthority> 
	authorities) {
		/*GrantedAuthority를 상속받은 자손타입으로만 제네릭 타입 형변환(제네릭 와일드카드 문자)을
		 * 허용하면서 권한 목록을 구함
		 */
		super(login_id, login_pwd,authorities); // 부모의 오버로딩 된 생성자를 호출하면서 아이디, 비번, 권한 목록을 전달한다.
	}
}