package annotation.quiz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Class<?> clz = BoardController.class;
		Object obj=null;
		try {
			obj = clz.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Method[] mArr = clz.getDeclaredMethods();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("경로 : ");
			String url = sc.nextLine();
			if (url.equals("quit")){
				break;
			}
			boolean bExist = false;
			for (Method m : mArr) {
				RequestMapping rm = m.getAnnotation(RequestMapping.class);
				
				if (rm==null) continue;
				if(rm.value().equals(url)) {
					try {
						m.invoke(obj);
						bExist = true;
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if(!bExist) {
				System.out.println("존재하지 않는 경로입니다.");
			}
			
		}
	}
}
