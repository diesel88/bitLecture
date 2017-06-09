package day14.quiz;

import java.io.File;
import java.util.Calendar;

/*
 *  현재 시간에 대한 디렉토리 생성하기
 *  생성할 위치
 *  iodata/day14
 *  2017/04/27/09
 */

public class Quiz01 {
	public static void main(String[] args) {
		String dir = "iodata/day14";
		
		Calendar cal = Calendar.getInstance();
		dir += "/"+cal.get(Calendar.YEAR);
		dir += String.format("/%02d",cal.get(Calendar.MONTH)+1);
		dir += String.format("/%02d",cal.get(Calendar.DATE));
		
		File file = new File(dir);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		
	}
}
