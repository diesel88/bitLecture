package kr.co.mlec.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mlec.form.MemberVO;

@Controller
@RequestMapping("/interceptor")
public class MyPage {
	@RequestMapping("/myPage.do")
	public String info(HttpSession session, Model model) {
	
		model.addAttribute("msg", "반갑습니다");
		return "interceptor/myPage";
	}
}
