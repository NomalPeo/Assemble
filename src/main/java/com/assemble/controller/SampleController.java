package com.assemble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*") // 컨트롤러 자체에 URL 매핑주소 sample등록
public class SampleController {
	
	@GetMapping("/all") // 로그인 하지 않은 사용자도 접근 가능한 매핑주소(URI)
	public void doAll() { // 리턴타입이 없는 void형이면  매핑주소인 all이 뷰페이지 파일명 all.jsp가 된다.
		System.out.println("do all can access every");
	}// doAll()
	
	@GetMapping("/member") // 로그인 한 사용자만 접근할 수 있는 매핑주소
	public void doMember() {
			System.out.println("logined member");
	}
	@GetMapping("/admin") // 로그인 한 사용자들 중에서 중에서 관리자 권한을 가진 사용자만 접근할 수 있는 매핑주소
	public void doAdmin() {
		System.out.println("admin only");
	}
}
