package aop.O2basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		try {
			Controller controller = new BoardController();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("BoardController.execute 메서드 호출시간 :" + sdf.format(new Date()));
			controller.service();

			controller = new MemberController();
			
			System.out.println("MemberController.execute 메서드 호출시간 :" + sdf.format(new Date()));
			controller.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
