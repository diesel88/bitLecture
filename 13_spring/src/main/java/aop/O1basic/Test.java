package aop.O1basic;

public class Test {
	public static void main(String[] args) {
		try {
			Controller controller = new BoardController();
			controller.service();

			controller = new MemberController();
			controller.service();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
