package org.springframework.web;

import java.lang.reflect.Method;

/**
 * 실행하려는 컨트롤러 객체와 메서드를 표현
 * @author Bit503-15
 *
 */
public class CtrlAndMethod {
	private Object target;
	private Method method;
	
	public CtrlAndMethod(Object target, Method method) {
		this.target = target;
		this.method = method;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	
	
}
