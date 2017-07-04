package aop.O3basic;


public class Test {
	public static void main(String[] args) {
		try {
			Controller controller = new ProxyController(new BoardController());
			
			
			controller.service();

			controller = new ProxyController(new MemberController());
			
			controller.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
