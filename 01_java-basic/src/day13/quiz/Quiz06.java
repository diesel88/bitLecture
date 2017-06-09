package day13.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("iodata/day13/quiz06.txt");
		Scanner sc = new Scanner(file);
		List<StudentVO> list = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] data = sc.nextLine().split(":");
			int[] scores = new int[3];
			for (int i=1; i<4; i++) {
				scores[i-1] = Integer.parseInt(data[i]);
			}
			StudentVO vo = new StudentVO(scores, data[0]);
			list.add(vo);
			
		}
		Collections.sort(list);
		System.out.println("성적발표");
		System.out.println("=======================");
		for (int i=0; i < 3; i++) {
			StudentVO vo = list.get(i);
			System.out.printf("%d. 이름  : %s, 총점 : %s\n", i+1, vo.getName(), vo.getTotScore());
		}
		System.out.println("=======================");
		
	}
}
