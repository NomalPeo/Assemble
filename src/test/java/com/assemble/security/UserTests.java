package com.assemble.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class UserTests {
	@Autowired // setter()를 통한 자동의존성 주입
	private PasswordEncoder pwencoder;

	@Autowired
	private DataSource ds; // 커넥션 풀 관리 ds(JNDI 디렉토리 서비스에 의한 dbcp)

	/*
	 * @Test public void testInsertMember() { String sql =
	 * "insert into users(user_no,user_id,user_pwd,user_name,user_gender,user_nickname,user_date) \r\n"
	 * + "values(users_seq.nextval,?,?,?,1,?,sysdate)";
	 * 
	 * for(int i = 1; i<20; i++) { Connection con = null; PreparedStatement pstmt =
	 * null;
	 * 
	 * try { con = ds.getConnection(); pstmt = con.prepareStatement(sql);
	 * 
	 * pstmt.setString(2, pwencoder.encode("pw"+i));
	 * 
	 * if(i<18) { pstmt.setString(1, "member"+i); // user0~user79까지 일반사용자 회원아이디
	 * pstmt.setString(3, "유저"+i); pstmt.setString(4, "nick"+i); }else {
	 * pstmt.setString(1, "admin"+i); // user0~user79까지 일반사용자 회원아이디
	 * pstmt.setString(3, "운영자"+i); pstmt.setString(4, "nick"+i); }
	 * pstmt.executeUpdate(); }catch(Exception e) { e.printStackTrace(); }finally {
	 * try { if(pstmt!=null) pstmt.close(); if(con!=null) con.close();
	 * }catch(Exception e) { e.printStackTrace(); } } } }
	 */
	@Test
	public void testInsertAuth() {
		String sql = "insert into users_auth(user_id, auth) values(?,?)";

		for (int i = 0; i < 20; i++) {
			Connection con = null; // DB연결
			PreparedStatement pstmt = null; // 쿼리문 수행

			try {
				con = ds.getConnection(); // 커넥션 풀 ds로 con생성
				pstmt = con.prepareStatement(sql);

				if (i < 18) {
					pstmt.setString(1, "member" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}// testInsertAuth()
}
