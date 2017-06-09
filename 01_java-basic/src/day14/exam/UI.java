package day14.exam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UI {
	Scanner sc = null;
	DAO dao = null;
	String str = "";
	public UI() {
		sc = new Scanner(System.in);
		try {
			dao = new DAO();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void service() {
		while (true) {
			System.out.println("항목을 선택하세요. (1.지역명 2.이름 3.종료) : ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1:
				showByArea();
				break;
			case 2:
				showByName();
				break;
			case 3:
				exit();
				break;
			}
		}
	}
	
	private void showByArea() {
		System.out.println("지역명을 입력하세요:");
		String area = sc.nextLine();
		
		List<VO> list = dao.getByArea(area);
		String result = "=================================\r\n";
		result += String.format("%s 검색된 결과 : %d명\r\n",area, list.size());
		if(list.size() > 0) {
			for (int i=0; i < list.size(); i++) {
				VO vo = list.get(i);
				result += String.format("이름 : %s, 거주지 : %s\r\n", vo.getName(), vo.getArea());
			}
		}
		result += "=================================\r\n";
		System.out.print(result);
		str += result;
	}
	private void showByName() {
		System.out.println("이름을 입력하세요:");
		String name = sc.nextLine();
		
		List<VO> list = dao.getByName(name);
		String result = "=================================\r\n";
		result += String.format(""
				+ "\"%s\"로 시작하는 사람 검색된 결과 : %d명\r\n",name, list.size());
		if(list.size() > 0) {
			for (int i=0; i < list.size(); i++) {
				VO vo = list.get(i);
				result += String.format("이름 : %s, 거주지 : %s\r\n", vo.getName(), vo.getArea());
			}
		}
		result += "=================================\r\n";
		System.out.print(result);
		str += result;
	}
	private void exit() {
		System.out.println("검색된 결과를 저장 후 종료하시겠습니까?( Y / N )");
		String sel = sc.nextLine().toUpperCase();
		if(sel.equals("N")) System.exit(0);
		else {
			dao.writeFile(str);
			System.exit(0);
		}
	}
	
}
