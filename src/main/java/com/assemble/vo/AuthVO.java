package com.assemble.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthVO {
    private String user_id;
    private String auth;


    public String getUser_id() {
        return user_id;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getAuth() {
        return auth;
    }


    public void setAuth(String auth) {
        this.auth = auth;
    }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return auth;
	}

    
}
