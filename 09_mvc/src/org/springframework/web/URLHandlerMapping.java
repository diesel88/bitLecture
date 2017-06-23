package org.springframework.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;



public class URLHandlerMapping {
	// url 과 연결된 Controller 클래스 정보 관리
	private Map<String, CtrlAndMethod> mappings;
	
	public URLHandlerMapping(String ctrlNames) throws Exception {
		mappings = new HashMap<>();

		String[] arr = ctrlNames.split(";");
		for (String ctrl : arr) {
			System.out.println("ctrl : " + ctrl.trim());
			Class<?> clz = Class.forName(ctrl.trim());
			Object obj = clz.newInstance();
			
			
			Method[] mArr = clz.getDeclaredMethods();
			for (Method m : mArr) {
				RequestMapping rm = m.getAnnotation(RequestMapping.class);
				if (rm == null) continue;
				
				mappings.put(rm.value(), new CtrlAndMethod(obj, m));
			}
		}
		
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		return mappings.get(uri);
	}
}







