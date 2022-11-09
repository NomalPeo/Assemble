package com.assemble.vo;

import java.util.List;

public class UsersVO {
	private int user_no;
	private String user_id;
	private String user_pwd;
	private String user_name;
	private int user_gender;
	private String user_nickname; 
	private String user_date;

	private List<AuthVO> authList;

	private int startrow;
	private int endrow;
	
    private String find_name;
    private String find_field;
	
	
	public String getFind_name() {
		return find_name;
	}

	public void setFind_name(String find_name) {
		this.find_name = find_name;
	}

	public String getFind_field() {
		return find_field;
	}

	public void setFind_field(String find_field) {
		this.find_field = find_field;
	}

	public int getStartrow() {
		return startrow;
	}

	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}

	public int getEndrow() {
		return endrow;
	}

	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(int user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_date() {
		return user_date;
	}

	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}

	public List<AuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}

	
	
	
	
	 
}
