package day10.quiz;

import java.util.Random;

public class Dice implements Game{

	Random r = new Random();
	@Override
	public int startGame(int you) {
		// TODO Auto-generated method stub
		int me = r.nextInt(6) + 1;
		int result = 0;
		if (you == me) {
			result = 1;
		}
		return result;
	}

}
