package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Test02 {
	public static void main(String[] args) {
		try {
//			exam01();
//			exam02();
//			exam03();	// variable argument 설명
//			quiz01();
			quiz02();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ArrayList에 있는 메서드 중에서 "i"로 시작하는
	 * 메서드의 이름을 화면에 출력
	 * @throws Exception
	 */
	private static void quiz01() throws Exception {
		Class<?> clz = ArrayList.class;
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			String name = m.getName();
			if (name.startsWith("i")) {
				System.out.println(name);
			}
		}
		
	}
	/**
	 * ArrayList의 메서드 중에서 반환타입이 void인 
	 * 메서드의 이름을 출력
	 * @throws Exception
	 */
	private static void quiz02() throws Exception {
		Class<?> clz = ArrayList.class;
		Method[] mArr = clz.getDeclaredMethods();
		for (Method m : mArr) {
			Class<?> rClz = m.getReturnType();
			String rName = rClz.getName();
			if (rName.equals("void")) {
				System.out.println(m.getName());
			}
		}
	}

	private static void exam02() throws NoSuchMethodException, SecurityException {
		// 특정 메서드 접근하기
		// Dog 클래스의 setName 메서드를 접근
		Class<?> clz = Dog.class;
		
//		Method method = clz.getDeclaredMethod("setName", String.class);
//		Method method = clz.getDeclaredMethod("getName");
		
		//setAge 접근
		Method method = clz.getDeclaredMethod("setAge", int.class);
		System.out.println("메서드 이름 : " + method.getName());
		Class<?> rClz = method.getReturnType();
		System.out.println("반환타입 : " + rClz.getName());
		// 파라미터 정보 확인
		Parameter[] pArr = method.getParameters();
		for (Parameter p : pArr) {
			Type t = p.getParameterizedType();
			System.out.println(t.getTypeName() + " " + p.getName());
		}
		System.out.println("-------------------------");
	}

	/**
	 * Class 객체의 메서드 정보 확인하기
	 * @throws Exception
	 */
	private static void exam01() throws Exception {
		Class<?> clz = Dog.class;
		System.out.println("Dog의 모든 메서드 정보 출력");
		Method[] mArr = clz.getDeclaredMethods();
		for (Method method : mArr) {
			System.out.println("메서드 이름 : " + method.getName());
			Class<?> rClz = method.getReturnType();
			System.out.println("반환타입 : " + rClz.getName());
			// 파라미터 정보 확인
			Parameter[] pArr = method.getParameters();
			for (Parameter p : pArr) {
				Type t = p.getParameterizedType();
				System.out.println(t.getTypeName() + " " + p.getName());
			}
			System.out.println("-------------------------");
		}
	}
	
	private static void exam03() {
		System.out.println(sum());
		System.out.println(sum(100));
		System.out.println(sum(100, 300, 400));
		System.out.println(sum(100, 300, 400, 300, 400));
	}
	
	private static int sum(int...nums) {
		System.out.println(nums.length);
		return 0;
	}
}
