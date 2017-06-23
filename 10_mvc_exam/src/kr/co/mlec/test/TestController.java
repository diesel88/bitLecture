package kr.co.mlec.test;

import org.springframework.web.Controller;
import org.springframework.web.RequestMapping;

@Controller
public class TestController {
	
	// /java94/test/list.jsp
	@RequestMapping("/test/list.do")
	public void test1() {
		System.out.println("test01 메서드 호출됨");
	}

}
