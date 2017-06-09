/*
* 실행시 출력결과가 아래와 같이 나오도록 Bus 클래스를 작성하시오
 * 
 * 출력결과 >
 * 
 	360번 버스 운행시작.
	승객 3명 승차.
	승객 1명 하차.
	승객 1명 승차.
	승객 2명 하차.
	승객 5명 승차.
	승객 3명 하차.
	360번 버스의 현재 승차인원: 3명.
	모든 버스의 누적 승차인원: 9명.
	740번 버스 운행시작.
	승객 2명 승차.
	승객 1명 하차.
	승객 3명 승차.
	승객 2명 하차.
	승객 2명 승차.
	승객 3명 하차.
	740번 버스의 현재 승차인원: 1명.
	모든 버스의 누적 승차인원: 16명.
 */
package day09.exam;
class Bus {
	public static int totCnt = 0;
	int no;
	int cnt;
	Bus() {
		
	}
	Bus(int no) {
		this.no = no;
		System.out.println(no+"번 버스 운행 시작.");
	}
	void ride() {
		ride(1);
	}
	void ride(int cnt) {
		this.cnt += cnt;
		totCnt += cnt;
		System.out.printf("승객 %d명 승차.\n", cnt);
	}
	void leave() {
		leave(1);
	}
	void leave(int cnt) {
		this.cnt -= cnt;
		System.out.printf("승객 %d명 하차.\n", cnt);
	}
	public String toString() {
		return String.format("%d번 버스의 현재 승차인원: %d명.\n모든 버스의 누적 승차인원: %d명.", no, cnt, totCnt);
	}
}
public class Exam01 {
	public static void main(String[] args) {
		Bus no360 = new Bus(360);
		no360.ride(3);
		no360.leave();
		no360.ride();
		no360.leave(2);
		no360.ride(5);
		no360.leave(3);
		System.out.println(no360);
		
		Bus no740 = new Bus(740);
		no740.ride(2);
		no740.leave(1);
		no740.ride(3);
		no740.leave(2);
		no740.ride(2);
		no740.leave(3);
		System.out.println(no740);
	}
}