package day15;

public class Lotto {
	private int num;
	private int count;
	
	public Lotto(int num, int count) {
		this.num = num;
		this.count = count;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return String.valueOf(num) + "\t";
	}
	
}
