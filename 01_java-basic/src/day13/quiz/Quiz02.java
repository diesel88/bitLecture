package day13.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class SingerVO {
	String name;
	String age;
	String janre;
	String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJanre() {
		return janre;
	}
	public void setJanre(String janre) {
		this.janre = janre;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
public class Quiz02 {
	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * 단, 각 데이터를 VO에 담고 처리한다.
		 * VO에 처리가 완성되면 Map에 담고 출력하도록 처리
		 *  
		 *  가수정보
		 *  -----------------------------------
		 *  아이유 	25세		발라드	여성
		 *  빅뱅		11세		힙합, 댄스 남성
		 *  신화		15세		댄스		남성
		 */
		File file = new File("iodata/day13/quiz02.txt");
		Scanner sc = new Scanner(file);
		Map<String, SingerVO> map = new HashMap<>();
		while (sc.hasNextLine()) {
			String[] data = sc.nextLine().split(":");
			SingerVO vo = new SingerVO();
			vo.setName(data[0]);
			vo.setAge(data[1]);
			vo.setJanre(data[2]);
			vo.setSex(data[3].equals("1") ? "남성" : "여성");
			map.put(vo.getName(), vo);
		}
		
		Set<Entry<String, SingerVO>> entrySet = map.entrySet();
		System.out.println("가수정보");
		System.out.println("------------------------------");
		for (Entry<String, SingerVO> entry : entrySet) {
			SingerVO vo = entry.getValue();
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getAge()+"세\t");
			System.out.print(vo.getJanre()+"\t");
			System.out.print(vo.getSex()+"\t\n");
		}
		System.out.println("------------------------------");
		
		
	}
}
