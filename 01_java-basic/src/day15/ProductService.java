package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
	Scanner sc1 = null;
	Scanner sc2 = null;
	List<Product> list = null;
	public ProductService(String fileName) throws FileNotFoundException {
		sc1 = new Scanner(System.in);
		File f = new File(fileName);
		sc2 = new Scanner(f);
		list = new ArrayList<>();
	}
	public void service() {
		readData();
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("상품관리 시스템");
			System.out.println("---------------------------------");
			System.out.println("1. 전체 검색");
			System.out.println("2. 금액 검색");
			System.out.println("3. 상품명 검색");
			System.out.println("4. 종료");
			System.out.println("---------------------------------");
			System.out.print("메뉴선택 : ");
			int num = Integer.parseInt(sc1.nextLine());
			
			switch(num) {
			case 1:
				searchAll();
				break;
			case 2:
				searchPrice();
				break;
			case 3:
				searchName();
				break;
			case 4:
				exit();
				break;
			}
		}
	}
	
	private void showList(List<Product> l){
		System.out.println("---------------------------------");
		System.out.println("제조회사\t상품명\t상품번호\t가격");
		System.out.println("---------------------------------");
		if( l.size() > 0){
			for(Product p : l) {
				System.out.println(p);
			}
		} else {
			System.out.println("검색된 상품 정보가 없습니다.");
		}
		System.out.println("---------------------------------");
		
	}
	private void searchAll() {
		showList(list);
	}
	private void searchPrice() {
		long s = 0, e = 0;
		System.out.println("---------------------------------");
		System.out.println("금액으로 검색");
		System.out.println("---------------------------------");
		System.out.print("낮은금액 : ");
		s = Long.parseLong(sc1.nextLine());
		System.out.print("높은금액 : ");
		e = Long.parseLong(sc1.nextLine());
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.printf("%d 원 ~ %d 원 사이의 상품\n", s, e);
		
		List<Product> ret = new ArrayList<>();
		for(Product p : list) {
			if (p.comparePrince(s, e)) ret.add(p);
		}
		
		showList(ret);
		
	}
	private void searchName() {
		System.out.println("---------------------------------");
		System.out.println("상품명 검색");
		System.out.println("---------------------------------");
		System.out.print("검색어 입력 : ");
		String name = sc1.nextLine();
		System.out.println("---------------------------------");
		System.out.printf("[%s]자를 포함하는 상품\n", name);
		
		List<Product> ret = new ArrayList<>();
		for(Product p : list) {
			if (p.compareName(name)) ret.add(p);
		}
		
		showList(ret);
		
	}
	private void exit() {
		System.out.println("---------------------------------");
		System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터) : ");
		String s = sc1.nextLine().toUpperCase();
		if (s.equals("N")) {
			System.out.println("취소하였습니다.");
			System.out.println("---------------------------------");
			return;
		}
		System.exit(0);
	}
	
	void readData() {
		while(sc2.hasNextLine()) {
			String line = sc2.nextLine();
			String[] sub = line.split(":");
			Product p = new Product(sub[0], sub[1], sub[2], Long.parseLong(sub[3]));
			list.add(p);
		}
	}
}
