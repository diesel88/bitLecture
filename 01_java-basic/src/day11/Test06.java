package day11;

public class Test06 {
	public static void main(String[] args) {
		try {
			String msg = null;
			// NullPointerException
			System.out.println(msg.length());

			// ArithmeticException
			System.out.println(1 / 0);
		} catch (NullPointerException | ArithmeticException e) { // 1.7 부터
			System.out.println("예외발생");
		} 
		 catch (Exception e) {
			e.printStackTrace();
		}
	}
}
