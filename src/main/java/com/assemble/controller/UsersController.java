package com.assemble.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
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

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class UsersController {
	@Autowired
	private PasswordEncoder pwencoder;

	@Autowired
	private UsersService usersService;

	//반복적인 코드 하나로 줄이기
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
	public String join_ok(UsersVO m) {
		m.setUser_pwd(pwencoder.encode(m.getUser_pwd()));
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
		UsersVO pm = this.usersService.pwdUsers(m); //아이디와 회원이름에 맞는 회원정보를 DB로 부터
		// 검색

		if (pm == null) {
			out.println("<script>");
			out.println("alert('회원정보를 찾을 수 없습니다.!\\n올바른 아이디와 이름을 입력하세요!');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			Random r = new Random();
			int pwd_random = r.nextInt(100000);
			String ran_pwd = Integer.toString(pwd_random); //정수숫자를 문자열로 변경


			m.setUser_pwd(pwencoder.encode(ran_pwd)); //비번 암호화
			this.usersService.updatePwd(m); //암호화된 비번 수정

			ModelAndView fm = new ModelAndView("myPage/pwd/pwd_find_ok");
			fm.addObject("ran_pwd", ran_pwd);
			return fm;
		}
		return null;
	}//pwd_find_ok()

	//로그인 인증후 메인화면
	@GetMapping("index")
	public String index(HttpServletResponse response, HttpSession session)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");

		if (isLogin(response, session)) { //로그인 성공시
			return "LoginJoin/Login/login";
		}
		return null;
	}//index();

	//마이페이지
	@GetMapping("/myPage")
	public ModelAndView mypage() {
		ModelAndView my = new ModelAndView();
		my.setViewName("myPage/myPage");
		return my;
	}//login()

	//회원탈퇴 폼
	@RequestMapping("/users_del")
	public String users_del(HttpServletResponse response,Principal principal)
			throws Exception{
		response.setContentType("text/html; charset=UTF-8");

		String username = principal.getName();
		this.usersService.getUsers(username);	
		return "myPage/del/del";

	}//User_del()

	/*회원 탈퇴 완료*/
	@PostMapping("users_del_ok")
	public String users_del_ok(HttpServletResponse response, HttpSession session,Principal principal,
			HttpServletRequest request,
			@RequestParam("del_pwd") String del_pwd,String del_cont, UsersVO dm) 
					throws Exception{

		response.setContentType("text/html; charset=UTF-8");

		request.setCharacterEncoding("UTF-8");

		PrintWriter out=response.getWriter();
		String username = principal.getName(); //세션 아이다값을 구함

		if(username == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("locaction='users_login';");
			out.println("</script>");	
		}else {
			del_pwd=pwencoder.encode(del_pwd); //비번을 암호화
			UsersVO db_pwd=this.usersService.getUsers(username);

			if(!db_pwd.getUser_pwd().equals(del_pwd)) {
				out.println("<script>");
				out.println("alert('비번이 다릅니다!');");
				out.println("history.go(-1);");
				out.println("</script>");
			}else {
				dm.setUser_id(username);
				this.usersService.authDel(dm.getUser_id());
				this.usersService.delUser(dm); //회원탈퇴

				out.println("<script>");
				out.println("alert('회원 탈퇴 했습니다 !');");
				out.println("location='users_login';");
				out.println("</script>");
			}//inner if else
		}//outer if else
		return null;	
	}//users_del_ok()




}