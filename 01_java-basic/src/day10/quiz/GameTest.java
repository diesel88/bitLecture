package day10.quiz;

import java.util.Random;
import java.util.Scanner;

public class GameTest {
	public static void main(String[] args) {
		Random r = new Random();
		int totScore = 0;
		Scanner sc = new Scanner(System.in);
		outer : while(true) {
			System.out.println("게임을 선택하세요");
			System.out.println("A. 가위바위보");
			System.out.println("B. 주사위 값 맞추기");
			System.out.println("C. 종료 ");
			String sel = sc.nextLine().trim().toUpperCase();
			int val = 0;
			switch (sel.charAt(0)) {
			case 'A':
				System.out.println("가위바위보 게임입니다.");
				System.out.println("가위바위보중 하나를 선택하세요.");
				System.out.println("(1:가위, 2:바위, 3보)");
				val = Integer.parseInt(sc.nextLine());
				while ( val < 1 || val > 3) {
					System.out.println("다시 입력하세요.");
					val = Integer.parseInt(sc.nextLine());
				}
				totScore += new ScissorsRockPaper().startGame(val);
				break;
			case 'B':
				System.out.println(">주사위 값 맞추기 게임입니다. ");
				System.out.println("주사위을 선택하세요(1~6값 중 하나) ");
				val = Integer.parseInt(sc.nextLine());
				while ( val < 1 || val > 6) {
					System.out.println("다시 입력하세요.");
					val = Integer.parseInt(sc.nextLine());
				}
				int ret = new Dice().startGame(val);
				System.out.println(ret == 1 ?"You Win":"You Lose");
				totScore += ret;
				break;
			case 'C':
				System.out.println("게임을 종료합니다.");
				System.out.printf("당신의 total score는 %d입니다.", totScore);
				break outer;
			}
			
		}
	}
}
