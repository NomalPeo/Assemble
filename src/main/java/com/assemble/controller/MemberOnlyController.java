package com.assemble.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assemble.service.UserOnlyService;
import com.assemble.service.UsersService;
import com.assemble.service.WishService;
import com.assemble.vo.UsersVO;
import com.assemble.vo.WishVO;
@Controller
@RequestMapping("/user/*")
public class MemberOnlyController {
	@Autowired
	private UserOnlyService userOnlyService;
	@Autowired
	private PasswordEncoder pwencoder;
	@Autowired
	private WishService wishService;

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
		this.userOnlyService.getUsers(username);
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
		try {
			PrintWriter out=response.getWriter();
			if(principal.getName() == null) {
				out.println("<script>");
				out.println("alert('다시 로그인 하세요!');");
				out.println("location='/users_login';");
				out.println("</script>");	
			}else {
				String username = principal.getName();
				del_pwd=pwencoder.encode(del_pwd); //비번을 암호화
				UsersVO db_pwd=this.userOnlyService.getUsers(username);

				if(!db_pwd.getUser_pwd().equals(del_pwd)) {
					out.println("<script>");
					out.println("alert('비번이 다릅니다!');");
					out.println("history.go(-1);");
					out.println("</script>");
				}else {
					dm.setUser_id(username);
					this.userOnlyService.authDel(dm.getUser_id());
					this.userOnlyService.delUser(dm); //회원탈퇴

					out.println("<script>");
					out.println("alert('회원 탈퇴 했습니다 !');");
					out.println("</script>");
					session.invalidate();
					return "index_1";
				}//inner if else
			}//outer if else
		}catch(Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("</script>");

			e.printStackTrace();
			return "redirect:/index_1";
		}
		return null;	
	}//users_del_ok()



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

	@RequestMapping("/secutiry_title")
	public String security_title(UsersVO vo,HttpServletRequest request,HttpServletResponse response,Principal principal) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String user_nickname = request.getParameter("user_nickname");
		String user_id_ = request.getParameter("user_id");
		String user_id = principal.getName();
		try {
			if(!(user_id.equals(user_id_))) {
				out.println("<script>");
				out.println("alert('아이디가 틀립니다');");
				out.println("location='/user/myPage';");
				out.println("</script>");
			}else{
				vo.setUser_id(user_id);
				vo.setUser_nickname(user_nickname);
				this.userOnlyService.updateUserSecurity(vo);

				out.println("<script>"); 
				out.println("alert('회원정보 변경');");
				out.println("location='/user/myPage';");
				out.println("</script>");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/PasswordChange")
	public String PasswordChange(HttpServletRequest request, HttpServletResponse response,Principal principal, UsersVO uv) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('기존 비밀번호와 일치하지 않습니다!');");
		out.println("</script>");
		String user_id = principal.getName();
		String pwd = userOnlyService.getUserPwd(user_id);
		out.println(pwd);
		String user_pwd = pwencoder.encode(request.getParameter("password_1"));
		out.println(user_pwd);
		try {
			if(pwd != user_pwd) {
				out.println("<script>");
				out.println("alert('기존 비밀번호와 일치하지 않습니다!');");
				out.println("location='/main';");
				out.println("</script>");
			}else {
				uv.setUser_id(user_id);
				uv.setUser_pwd(user_pwd);
				this.userOnlyService.updateUserPwd(uv);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="/wish", method=RequestMethod.GET)
	   public String thema_content (Model contM, HttpServletRequest request, WishVO wl, Principal principal){

		  String user_id = principal.getName();
		  wl.setWish_id(user_id);
	      List<WishVO> w_list = this.wishService.getWish(wl);

	      contM.addAttribute("w_list", w_list);
	      contM.addAttribute("wishmsg", "찜목록이 없습니다.");

	      return "myPage/wish";
	   }

	   @RequestMapping(value="/wish_ok", method=RequestMethod.POST)
	   public ModelAndView wish_ok (WishVO wo, HttpServletRequest request,Principal prin) {
		  ModelAndView mc = new ModelAndView();
		  String user_id = prin.getName();
		  wo.setWish_id(user_id);
		  String thumbnail = request.getParameter("thumbnail");
	      String title = request.getParameter("title");
	      wo.setWish_thumbnail(thumbnail);
	      wo.setWish_title(title);

	      this.wishService.wish_ok(wo);

	      return new ModelAndView("redirect:/user/wish");
	      }
	   
	   
	   @RequestMapping("/wish_del")
	   public String wish_del(String wish_title, RedirectAttributes rttr) {
	      this.wishService.deleteWish(wish_title);
	      rttr.addFlashAttribute("msg","SUCCESS");
	      return "redirect:/user/wish";
	   }











}
