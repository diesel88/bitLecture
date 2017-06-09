package day15;

import java.io.*;
import java.util.Scanner; 

public class Exam01 { 

    public static void dataCheck(String file1 , String file2) throws Exception{
        // 구현하세요~ ---------------------------------------------------
        // 비교 대상 파일인 file1 과 file2 에는 문자열 데이터의 라인수가 같다고 가정합니다~!!

        // --------------------------------------------------------------
    	File f1 = new File(file1);
    	File f2 = new File(file2);
    	Scanner sc1 = new Scanner(f1);
    	Scanner sc2 = new Scanner(f2);
    	
    	int i = 1;
    	while (sc1.hasNextLine()) {
    		String str1 = sc1.nextLine().toUpperCase();
    		String str2 = sc2.nextLine().toUpperCase();
    		
    		System.out.printf("Lind %d : %s\n", i, str1.equals(str2) ? "Equal" : "Not Equal");
    		i++;
    	}
    }   
    
    // main 메서드는 수정하지 마세요.
    public static void main(String[] args) throws Exception {       
        try {
            dataCheck("iodata/data1.txt", "iodata/data2.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}