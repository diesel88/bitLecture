package day12.quiz;

import java.util.Calendar;

public class Quiz01 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.printf("\t\t%d년 %d월\n",c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		c.set(Calendar.DATE, 1);
		int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int beforeDay = c.get(Calendar.DAY_OF_WEEK) - 2; 
		c.set(Calendar.DATE, maxDay );
		int afterDay = 7 - c.get(Calendar.DAY_OF_WEEK) + 1;
		int totDay = maxDay + beforeDay + afterDay;
		
		c.set(Calendar.DATE, 1);
		if( beforeDay > 0) {
			c.add(Calendar.MONTH, -1);
			c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			c.add(Calendar.DATE, -beforeDay);
		}
		for ( int i = 0; i < totDay; i++) {
			System.out.printf("%2d\t", c.get(Calendar.DATE));
			if((i+1) % 7 == 0) System.out.println();
			c.add(Calendar.DATE, 1);
			
		}
	}
}
