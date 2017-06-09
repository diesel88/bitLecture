package day07.exam;

public class Exam03 {
//두개의 숫자를 입력받아 큰수를 반환하는 max( int i, int j) 메소드를 작성하시오
	
	public static int max( int i, int j) {
		if (i > j) {
			return i;
		}
		else {
			return j;
		}
	}
	public static void main(String[] args) {
		System.out.println(max( 2, 3));
	}
}
