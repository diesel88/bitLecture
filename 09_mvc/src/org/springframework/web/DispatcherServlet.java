// ~~.jar
package org.springframework.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	
	private static final String REDIRECT_PRIFIX = "redirect:";
	private static final String AJAX_PRIFIX = "ajax:";
	private URLHandlerMapping mappings;
	private String prefix, suffix;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String ctrlNames = config.getInitParameter("controllers");
		prefix = config.getInitParameter("prefix");
		suffix = config.getInitParameter("suffix");
		try {
			
		mappings = new URLHandlerMapping(ctrlNames);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	@Override
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 사용자 요청과 연관된 작업 컨트롤러를 찾는다.
		// 1. 사용자 요청 URI 가져오기
		String uri = request.getRequestURI();
		
//		uri = uri.substring("/09_mvc".length());
//		/09_mvc/board/list.do
		
		// 웹 어플리케이션명(웹프로젝트명) 동적 가져오기
		String contextPath = request.getContextPath();
		System.out.println("project name : " + contextPath);
		
		uri = uri.substring(contextPath.length());
		try {

			// uri 와 연관된 컨트롤러 클래스 호출
			// 컨트롤러 클래스 : 서블릿 (X)
			CtrlAndMethod cam = mappings.getCtrlAndMethod(uri); 
			
			// uri 잘못된 경우 
			if (cam == null) {
				throw new ServletException(
					"요청하신 URL이 존재하지 않습니다."
				);
			}
			// 실행하기 위해서 cam 클래스에 있는 값을 추출
			Object target = cam.getTarget();
			Method m = cam.getMethod();
			
			
			// 메서드에 있는 파라미터 정보 추출
			PreParameterProcess ppp = new  PreParameterProcess();
			Object[] param = ppp.process(request, m);
			
			// 반환타입 처리
			Class<?> rType = m.getReturnType();
			String rName = rType.getSimpleName();
			String view = "";
			ModelAndView mav = null;
			
			switch (rName) {
			case "String":
				view = (String)m.invoke(target, param);
				break;
			case "void":
				m.invoke(target, param);
				view = uri.replace(".do", "");
				break;
			case "ModelAndView":
				mav = (ModelAndView)m.invoke(target, param);
				view = mav.getView();
				break;
			}
			
			
			// 화면 페이지 이동 - forward, sendRedirect
			// view 가 redirect: 으로 시작하면 sendRedirect
			//        ajax: 으로 시작하면 ajax 처리
			// 위의 두 경우가 아니라면 forward
			if (view.startsWith(REDIRECT_PRIFIX)) {
				response.sendRedirect(
					view.substring(REDIRECT_PRIFIX.length())
				);
			} 
			else if (view.startsWith(AJAX_PRIFIX)) {
					response.setContentType("text/json; charset=utf-8"); 
					// ajax 인 경우
					// view : "ajax:{a: 'aaa'}"
					// substring 작업 후 view : "{a: 'aaa'}"
					PrintWriter out = response.getWriter();
					out.println(view.substring(AJAX_PRIFIX.length()));
				
				}
			else {
				if (mav != null) {
					Map<String, Object> map = mav.getModel();
					Set<String> set = map.keySet();
					for (String key : set) {
						request.setAttribute( key, map.get(key));
					}
				}
				RequestDispatcher rd = 
						request.getRequestDispatcher(prefix+view+suffix);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}









