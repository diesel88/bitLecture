package day14;

class Test {
	int value;
}

public class SwapTest {
	
	public static void main(String[] args) {
		
		Test a = new Test();
		Test b = new Test();
		a.value = 10;
		b.value = 20;
		
		swap(a,b);
		System.out.println("a=" + a.value);
		System.out.println("b=" + b.value);
	}
	
	public static void swap(Test a, Test b) {
		Test temp = new Test();
		temp.value= a.value;
		a.value = b.value;
		b.value = temp.value;
	}
}
