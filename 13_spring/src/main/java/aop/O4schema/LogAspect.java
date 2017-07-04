package aop.O4schema;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * 공통 로그 기능
 * @author Bit503-15
 *
 */
public class LogAspect {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void showLog(JoinPoint joinPoint) {
		// JoinPoint : 공통기능이 수행된 핵심기능 클래스 정보 얻기
//		String clzName = controller.getClass().getName();
		
		// 핵심기능 클래스
		Object target = joinPoint.getTarget();
		Class<?> clz = target.getClass();
		
		// 핵심기능 클래스의 실행된 메서드 정보 얻기
		Signature sign = joinPoint.getSignature();
		
		String clzName = clz.getName();
		String methodName = sign.getName();
		
		System.out.println(clzName + "."+ methodName + "메서드 호출시간 :" + sdf.format(new Date()));
	}
}
