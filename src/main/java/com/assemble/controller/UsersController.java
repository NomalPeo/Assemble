package com.assemble.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assemble.service.UsersService;
import com.assemble.vo.UsersVO;


@Controller
public class UsersController {
	@Autowired
	private PasswordEncoder pwencoder;

	@Autowired
	private UsersService usersService;

	public static boolean isLogin(HttpServletResponse response, HttpSession session)
			throws Exception {
		PrintWriter out = response.getWriter();
		String id = (String) session.getAttribute("id");

		if (id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='users_login';");
			out.println("</script>");
			return false;
		}
		return true;
	}


	@RequestMapping("users_login")
	public String login(String error, String logout, Model model) {
		System.out.println("error : " + error);
		System.out.println("logout : " + logout);

		if(error != null) {
			model.addAttribute("error","Login Error Check Your Account");
		}
		if(logout != null) {
			model.addAttribute("logout", "LogOut!!");
		}
		return "LoginJoin/Login/login";
	}//login()

	@RequestMapping("/login_ok")
	public String login(@RequestParam("login_id")String login_id,HttpSession session, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		UsersVO dm = this.usersService.loginCheck(login_id);
		if(dm == null) {
			session.invalidate();
		}
		return "index_1";
	}


	@RequestMapping("/user_logout")
	public String logout (HttpSession sesseion) {
		sesseion.invalidate();
		return "index_1";
	}
	@RequestMapping("join") //회원가입
	public String join() {

		return "LoginJoin/join/join";
	}//users_join()

	//아이디 중복검색
	@PostMapping("/users_idcheck")
	public String users_idcheck(@RequestParam("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		UsersVO db_id = this.usersService.idCheck(id);
		int re = -1;

		if (db_id != null) {
			re = 1;
		}
		out.println(re);
		return null;
	}//users_id()

	//회원저장
	@RequestMapping("join_ok")
	public String join_ok(UsersVO m, HttpServletRequest request) {
		String user_pwd = pwencoder.encode(request.getParameter("user_pwd"));
		System.out.println(user_pwd);
		m.setUser_pwd(user_pwd);
		this.usersService.insertUsers(m);
		this.usersService.authinsertUsers(m.getUser_id().toString());
		return "LoginJoin/Login/login";
	}//join_ok()
	
	//비밀번호찾기 공지창
	@GetMapping("pwd_find")
	public String pwd_find() {
		return "myPage/pwd/pwd_find"; // /WEB-INF/views/users/pwd_find.jsp
	}//pwd_find()


	//비번찾기 결과
	@PostMapping("pwd_find_ok")
	public ModelAndView pwd_find_ok(String pwd_id, String pwd_name, HttpServletResponse
			response, UsersVO m) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		m.setUser_id(pwd_id);
		m.setUser_name(pwd_name);
		UsersVO pm = this.usersService.pwdUsers(m);
		if (pm == null) {
			out.println("<script>");
			out.println("alert('회원정보를 찾을 수 없습니다.!\\n올바른 아이디와 이름을 입력하세요!');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			Random r = new Random();
			int pwd_random = r.nextInt(100000);
			String ran_pwd = Integer.toString(pwd_random);
			m.setUser_pwd(pwencoder.encode(ran_pwd));
			this.usersService.updatePwd(m);
			ModelAndView fm = new ModelAndView("myPage/pwd/pwd_find_ok");
			fm.addObject("ran_pwd", ran_pwd);
			return fm;
		}
		return null;
	}















	@GetMapping("index")
	public String index(HttpServletResponse response, HttpSession session)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");

		if (isLogin(response, session)) { //로그인 성공시
			return "LoginJoin/Login/login";
		}
		return null;
	}//index();




}