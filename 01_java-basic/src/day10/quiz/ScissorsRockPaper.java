package day10.quiz;

import java.util.Random;

public class ScissorsRockPaper implements Game{
	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;
	final static int[][] DATA = {{3, 1, 2}, {1, 2, 3}, {2, 3, 1}};
	final static String[] ARRAY = {"가위", "바위", "보"};
	Random r = new Random();
	@Override
	public int startGame(int you) {
		// TODO Auto-generated method stub
		int me = r.nextInt(3) + 1;
		int result = 0;
		String sResult = "";

		int i = you - 1;
		for (int j = 0; j < DATA[i].length; j++) {
			if ( DATA[i][j] == me ) {
				switch(j) {
				case 0: 
					result = 1;
					sResult = "You Win";
					break;
				case 1:
					result = 0;
					sResult = "비겼습니다.";
					break;
				case 2:
					result = 0;
					sResult = "You Lose";
					break;
				}
			}
			}
		System.out.println("me\tyou\t출력결과");
		System.out.printf("%s(%d)\t%s(%d)\t%s\n",ARRAY[me-1],me,ARRAY[you-1],you,sResult);
		return result;
	}

}
