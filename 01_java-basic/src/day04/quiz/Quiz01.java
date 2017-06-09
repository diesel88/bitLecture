package day04.quiz;

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 * 1부터 10사이의 숫자중에서
		 * 3의 배수는 출력하고
		 * 3의 배수가 아닌 숫자는 2배수를 출력한다
		 * 
		 * 출력형식
		 * 2
		 * 4
		 * 3
		 * 8
		 * 10
		 * 6
		 * ..
		 * ..
		 * 20
		 */
		for(int i = 1; i <= 10; i++){
			int j;
			//			int j = i;
//			if(i % 3 == 0){
//				j = i;
//			}
//			else{
//				j = i * 2;
//			}
			
			System.out.println((i % 3 == 0)?i : i*2);
		}
	}
}
