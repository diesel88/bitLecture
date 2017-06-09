package net05.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test03 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://www.daum.net").get();
			
			Elements elements = doc.select("a.link_weather"); 
			for (Element e : elements) {
				System.out.println(e.html());
//				String rank = e.select(".ah_r").html();
//				String keyword = e.select(".ah_k").html();
//				System.out.println(rank + "-" + keyword);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
