package day03;

public class Test06 {
	public static void main(String[] args) {
		
		int j = 10;
		j = j + 10;
		j += 10;
		
		j = j - 10;
		j -= 10;
		
		j = j * 10;
		j *= 10;
		
		int num = 5;
		num *= 5 + 3;
		//num = num * (5 + 3);
		System.out.println(num);
		
		int k = 5;
		int m = 5;
//		System.out.println(k > 5 && m++ == 5);
		System.out.println(k == 5 || m++ == 5);
		System.out.println("m: "+m);
		
		System.out.println((5 == 5)? "같다" : "다르다");
		System.out.println((5 != 5)? "같다" : "다르다");
		
		
		int a = 5;
		int b = ++a;
		System.out.println(a + ", " + b);
		
		a = 5;
		b = a++;
		System.out.println(a + ", " + b);
	}
}
