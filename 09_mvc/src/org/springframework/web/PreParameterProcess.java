package org.springframework.web;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

public class PreParameterProcess {

	public Object[] process(
			HttpServletRequest request, Method m) throws Exception {
		Parameter[] pArr = m.getParameters();
		Object[] rArr = new Object[pArr.length];
		
		// 값을 입력할 위치 변수
		int index = 0;
		
		for (Parameter p : pArr) {
			// 파라미터 타입 정보 추출하기
			Class<?> tClz = p.getType();
			// 파라미터 타입의 이름
			String tName = tClz.getSimpleName();
			// 파라미터명
			String pName = p.getName();
			
			RequestParam rp = 
					p.getAnnotation(RequestParam.class);
			String defaultValue = "";
			if (rp != null) {
				pName = rp.value();
				defaultValue = rp.defaultValue();
			}
			
			// 파라미터의 타입명에 따른 처리
			// String, int, HttpServletRequest, 사용자 VO
			switch (tName) {
			case "String":
				rArr[index++] = 
						request.getParameter(pName); 
				break;
			case "int":
				String value = request.getParameter(pName);
				if (value == null) {
					value = defaultValue;
				}
				rArr[index++] = Integer.parseInt(value); 
				break;
			case "HttpServletRequest":
				rArr[index++] = request; 
				break;
			default:
				rArr[index++] = 
					WebUtil.toVO(request, tClz);
				break;
			}
		}
		return rArr;
	}
	
}









