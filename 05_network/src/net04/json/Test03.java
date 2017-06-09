package net04.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

public class Test03 {
	public static void main(String[] args) {
		
		try {
			String path = "https://apis.daum.net/search/knowledge";
			String param = "?apikey=c9ac8a3d9e9a890c582b715ef06d5377&q=java&result=5&output=json";
			URL url = new URL(path+param);
			
			//다음 API 서버에 접근
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				
				sb.append(line);
			}
			Gson gson = new Gson();
			BlogVO vo = gson.fromJson(sb.toString(), BlogVO.class);
			List<Item> list = vo.getChannel().getItem();
			
			for (Item item : list) {
				System.out.println("answercount : " + item.getAnswerCount());
				System.out.println("title : " + item.getTitle());
				System.out.println("description : " + item.getDescription());
				System.out.println("category : " + item.getCategory());
				System.out.println("link : " + item.getLink());
				System.out.println("pubdate : " + item.getPubDate());
				System.out.println("");
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
