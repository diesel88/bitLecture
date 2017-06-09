package day08;

public class Test01 {
	public static void main(String[] args) {
		//StringBuffer - 동기화
		//StringBuilder - 비동기화
		System.out.println("문자열 성능 테스트");
		String s = new String("a");
		// 시간..
		long start = System.currentTimeMillis();
		for (int i=0; i < 100000; i++) {
			s += i;
		}
		// 시간..
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start) / 1000d);
		
		StringBuffer s2 = new StringBuffer("a");
		start = System.currentTimeMillis();
		for (int i=0; i < 100000; i++) {
			s2.append(i);
		}
		end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start) / 1000d);
	}
}
