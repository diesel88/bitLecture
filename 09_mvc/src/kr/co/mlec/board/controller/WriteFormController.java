package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

public class WriteFormController implements Controller {
	
	public WriteFormController() { }
	
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		// 화면 페이지 이동
		return new ModelAndView("/view/board/writeForm.jsp");
	}
}














