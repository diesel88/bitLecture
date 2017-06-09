package day05;

import java.util.Arrays;

public class Test06 {
	public static void main(String[] args) {
		String[][] a = { {"a", "b", "c"}, {"d", "e", "f"}};
		String[][] b = new String[2][];
		
		System.arraycopy(a, 0, b, 0, a.length);
		for(int i=0; i < a.length; i++)
		System.out.println(Arrays.toString(b[i]));
	}
}	
