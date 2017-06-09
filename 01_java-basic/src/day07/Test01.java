package day07;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		
		Sub01 sub = new Sub01();
		sub.method01();
		sub.method02(10);
		int i = 100;
		sub.method02(i);
		sub.method03(10, 20);
		sub.method04('a');
		sub.method05("abc");
		sub.method06(new int[3]);
		Random r = new Random();
		sub.method07(r);
		
	}
}
