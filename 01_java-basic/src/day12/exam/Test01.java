package day12.exam;

import java.util.Calendar;
import java.util.Scanner;

public class Test01 {
	static Calendar c = Calendar.getInstance();
	public static void showMonth(int sel) {
		switch(sel) {
		case 1:
			break;
		case 2:
			c.add(Calendar.MONTH, -1);
			break;
		case 3:
			c.add(Calendar.MONTH, 1);
			break;
		}
		System.out.printf("%d년 %2d월\n", c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int lastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int nlCnt = 0;
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		int dayWeek = c.get(Calendar.DAY_OF_WEEK);
		
		c.add(Calendar.MONTH, -1);
		int prevLastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int viewDay = prevLastDate - dayWeek + 2;
		
		for (int i = 1; i < dayWeek; i++) {
			System.out.print("\t");
			nlCnt++;
		}
		for (int i = 1; i <= lastDate; i++) {
			System.out.print(i + ((++nlCnt % 7 == 0) ? "\n" : "\t"));
		}
		System.out.println();
		c.add(Calendar.MONTH, 1);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("항목을 선택하세요(1. 현재달 보기 2. 이전달 보기 3. 다음달보기 0. 종료) : ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1:
			case 2:
			case 3:
				showMonth(num);
				break;
			case 0:
				System.exit(0);
				default:
					continue;
			}
		}
	}
}
