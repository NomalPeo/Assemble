package com.assemble.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

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

    @GetMapping("/Login/login")
    public void login() {

    }//login()

    @RequestMapping("join") //회원가입
    public String join(Model m) {
        String[] phone = {"010", "011", "016"};
        String[] email = {"직접입력", "gmail.com", "naver.com", "daum.net"};

        m.addAttribute("phone", phone);
        m.addAttribute("email", email);
        return "join/join";
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
    @RequestMapping("/join_ok")
    public String join_ok(UsersVO m) {
        m.setUser_pwd(pwencoder.encode(m.getUser_pwd()));
        //m.setUser_pwd(PwdChange.getPassWordToXEMD5String(m.getUser_pwd()));
        this.usersService.insertUsers(m);
        this.usersService.authinsertUsers(m.getUser_id().toString());
        return "Login/login";
    }//join_ok()


    //비밀번호찾기 공지창
    @GetMapping("/pwd_find")
    public String pwd_find() {
        return "pwd/pwd_find"; // /WEB-INF/views/users/pwd_find.jsp
    }//pwd_find()

    //비번찾기 결과
    @PostMapping("/pwd_find_ok")
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

            ModelAndView fm = new ModelAndView("pwd/pwd_find_ok");
            fm.addObject("ran_pwd", ran_pwd);
            return fm;
        }
        return null;
    }//pwd_find_ok()


    @GetMapping("/accessError") // get으로 접근하는 accessError 매핑주소가 실행
    public void accessDenied(Model model) {
        // 리턴 타입이 없는 void형이면 매핑주소가 jsp뷰페이지 파일명이 된다.
        System.out.println("access Denied");
        model.addAttribute("msg", "Access Denied"); // 뷰페이지에서 EL로 ${msg} 키이름을 참조해서 값을 가져온다.
    }

    //로그인 인증후 메인화면
    @GetMapping("index")
    public String index(HttpServletResponse response, HttpSession session)
            throws Exception {
        response.setContentType("text/html; charset=UTF-8");

        if (isLogin(response, session)) { //로그인 성공시
            return "Login/login";
        }
        return null;
    }//index();

    //로그아웃
    @PostMapping("/users_logout")
    public String users_logout(HttpServletResponse response, HttpSession session,
                               HttpServletRequest request) throws Exception {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        session.invalidate(); //세션 만료 => 로그아웃

        out.println("<script>");
        out.println("alert('로그아웃 되었습니다!');");
        out.println("location='users_login';");
        out.println("</script>");

        return null;
    }//users_logout()


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

}