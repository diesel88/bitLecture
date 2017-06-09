package day15;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person { 
	private String name;
	private String age;
	private String dept;
	private String salary;
	
	public Person(String name, String age, String dept, String salary) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getDept() {
		return dept;
	}

	public String getSalary() {
		return salary;
	}
	
	public boolean compare(String lastName) {
		return name.startsWith(lastName);
	}
	
	public String toString() {
		return String.format("이름: %s\t나이 : %s\t부서 : %s\t 월급 : %s, ",
				 name, age, dept, salary);
	}
	
	
}

public class Exam03 {
    public static void main(String[] args) {
        try {
            searchEmployeeInfo("iodata/employee.txt", "김");
            searchEmployeeInfo("iodata/employee.txt", "다");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param readFileName : 읽을 파일명
     * @param lastName     : 찾을 성씨
     * @throws Exception
     */
    public static void searchEmployeeInfo(String readFileName, String lastName) 
            throws Exception {

        // 내용 구현
    	File f = new File(readFileName);
    	Scanner sc = new Scanner(f);
    	
    	List<Person> list = new ArrayList<>();
    	System.out.println("========================================");
    	while (sc.hasNextLine()) {
    		String line = sc.nextLine();
    		String[] sub = line.split(":");
    		Person p = new Person(sub[0], sub[1], sub[2], sub[3]);
    		if (p.compare(lastName)) {
    			list.add(p);
    			System.out.println(p);
    		}
    	}
    	System.out.println("========================================");
    	System.out.printf("%s씨 성을 가진 회원은 총 %d명 입니다.\n", lastName, list.size());
    	System.out.println("========================================");
    }   
}