package day07;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		Sub03 sub = new Sub03();
		int sum = sub.add(100, 200);
		System.out.println(sum);
		
		sum = sub.cal(1, 150, 250);
		System.out.println("합:" + sum);
		System.out.println(Arrays.toString( sub.makeNumbers(5) ));
		System.out.println(Arrays.toString( sub.makeNumbers(6, 45) ));
	}
}
