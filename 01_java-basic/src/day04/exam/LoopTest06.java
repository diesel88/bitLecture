package day04.exam;

public class LoopTest06 {
/*
 * 
 */
	public static void main(String[] args) {
		System.out.println("\t:\t1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("---------------------------------------------------------------------------------------");
		for (int i = 2; i < 10; i++) {
			System.out.print("\t" + i + "단\t");
			for (int j = 1; j < 10; j++) {
				System.out.print((i * j)+"\t");
				
			}
			System.out.println();
		}
		
	}
}
