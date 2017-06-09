package day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
//		Set<String> set = new TreeSet<>();
		
		System.out.println(set.add("one"));
		System.out.println(set.add("two"));
		System.out.println(set.add("three"));
		
		System.out.println("크기 : " + set.size());
		System.out.println(set.add("two"));
		System.out.println("two 입력 후 크기 : " + set.size());
		
		set.remove("one");
		
		for (int i = 0; i < set.size(); i++) {
			// ??
		}
		System.out.println("--------------------------");
		for (String data : set) {
			System.out.println(data);
		}
		System.out.println("--------------------------");
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
