package day04.exam;

public class LoopTest01 {
	//1부터 100까지의 정수를 출력하되 한 줄에 10개씩 출력하시오
	public static void main(String[] args) {
		for (int i=1; i < 101; i++) {
			System.out.print(i+" ");
			if (i % 10 == 0) {
				System.out.println();
			}
		}
	}
}
