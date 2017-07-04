package aop.O5anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	// Around 공통기능에서는 핵심기능을 직접 호출
	// 호출시 활용 클래스 : ProceedingJoinPoint.proceed()
	@Around("execution(public * aop.O5anno.*Controller.service(..))")
	public void exeTime(ProceedingJoinPoint pjp) throws Throwable{
		long s = System.currentTimeMillis();
		try {
			pjp.proceed();
		} finally {
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("실행시간 : " + time);
		}
	}
}
