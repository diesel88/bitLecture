package day15;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoService {
	Scanner sc = null;
	FileReader fr = null;
	FileWriter fw = null;
	List<List<Lotto>> list = null;
	String str="";
	String fileName = "";
	public LottoService(String fileName) throws IOException {
		this.fileName = fileName;
		File f = new File(fileName);
		if(!f.exists()) {
			f.createNewFile();
		}
		sc = new Scanner(System.in);
		fr = new FileReader(fileName);
		
		list = new ArrayList<>();
		readData();
	}
	
	public void service() throws IOException {
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("로또(LOTTO) 관리자 시스템");
			System.out.println("---------------------------------");
			System.out.println("1. 각 회별 로또 번호 보기");
			System.out.println("2. 번호별 당첨된 횟수 보기");
			System.out.println("3. 당첨 번호 등록");
			System.out.println("4. 종료");
			System.out.println("---------------------------------");
			System.out.print("메뉴 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1:
				searchAll();
				break;
			case 2:
				searchNumber();
				break;
			case 3:
				register();
				break;
			case 4:
				exit();
				break;
			}
		}
	}
	private void exit() {
		System.out.println("---------------------------------");
		System.out.print("종료하시겠습니까? (취소 : N, 종료 : 엔터) : ");
		String sel = sc.nextLine().toUpperCase();
		if (!sel.equals("N")){
			System.out.println("종료되었습니다.");
			System.out.println("---------------------------------");
			System.exit(0);
		}
	}
	private void searchNumber() {
		System.out.println("번호별 당첨 횟수");
		System.out.println("---------------------------------");
		for (int i=1; i < 46; i++) {
			int cnt = 0;
			for (List<Lotto> l : list) {
				for (Lotto lotto : l) {
					if (lotto.getNum() == i) cnt++;
				}
			}
			System.out.printf("%d번:%d회", i, cnt);
			System.out.print(i % 5 == 0 ? "\n" : "\t");
		}
		System.out.println("---------------------------------");
	}
	
	private void register() throws IOException {
		fw = new FileWriter(fileName,true);
		System.out.println("---------------------------------");
		System.out.println("로또 당첨 번호 등록");
		System.out.println("---------------------------------");
		System.out.print("회차 : ");
		int num = Integer.parseInt(sc.nextLine()) - 1;
		System.out.print("당첨번호 : ");
		String line = sc.nextLine();
		String[] sub = line.split(" ");
		List<Lotto> l = new ArrayList<Lotto>();
		line = "";
		for(int i =0; i< sub.length; i++) {
			Lotto lotto = new Lotto(Integer.parseInt(sub[i]), num+1);
			l.add(lotto);
			line += String.valueOf(lotto.getNum())+(i==sub.length-1?"\n":":");
//			line += String.valueOf(lotto.getNum())+(i==sub.length-1?"":":");
		}
		if(num < list.size()) {
			System.out.print("당첨번호 : ");
			l = list.get(num);
			for(Lotto lotto : l) {
				System.out.print(lotto);
			}
			System.out.println("\n이미 등록된 회차입니다.");
			System.out.println("---------------------------------");
		} else {
			list.add(l);
			fw.write(line);
		}
		fw.close();
	}
	
	private void searchAll() {
		System.out.printf("총 %d회\n", list.size());
		System.out.println("---------------------------------");
		for (int i= list.size() -1; i >=0; i--) {
			List<Lotto> l = list.get(i);
			System.out.print((i+1)+"회.\t");
			for (int j = 0; j < l.size(); j++) {
				Lotto lotto = l.get(j);
				System.out.printf("%d%s",lotto.getNum(),  j==l.size() - 1 ? "\n":"\t");
			}
		}
		
	}
	
	private void readData() throws IOException {
		int len = -1;
		while (true) {
			char[] buffer = new char[1024];
			len = fr.read(buffer);
			System.out.println(len);
			if (len == -1) {
				break;
			}
			str += String.valueOf(buffer);
		}
		if(str.length() == 0) return;
		str = str.substring(0, str.length() - 2);
		String[] lines = str.split("\n");
		for(int i=0; i < lines.length; i++) {
			
			String[] sub = lines[i].split(":");
			if (sub.length < 6) continue;
			List<Lotto> l = new ArrayList<>();
			
			for(int j=0; j < sub.length; j++) {
				Lotto lotto = new Lotto(Integer.parseInt(sub[j].trim()),i+1);
				l.add(lotto);
			}
			list.add(l);
		}
		
		fr.close();
	}
}
