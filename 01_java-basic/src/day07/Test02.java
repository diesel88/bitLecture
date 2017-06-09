package day07;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Sub02 sub = new Sub02();
		int val = sub.method02();
		char val2 = sub.method03();
		String str = sub.method04();
		Random r = sub.method05();
		
		HaHa ha = sub.test(new KiKi());
		ha.test();
	}
}
