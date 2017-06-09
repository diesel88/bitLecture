package net03.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test05 {
	public static void main(String[] args) {
		
		try {
			String path = "https://apis.daum.net/search/knowledge";
			String param = "?apikey=c9ac8a3d9e9a890c582b715ef06d5377&q=java&result=5&output=xml";
			URL url = new URL(path+param);
			
			//다음 API 서버에 접근
			InputStream in = url.openStream();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(in);
			NodeList list = doc.getElementsByTagName("item");
			int len = list.getLength();
			List<ItemVO> items = new ArrayList<>();
			for (int i=0; i < len; i++) {
				Node node = list.item(i);
				NodeList cList = node.getChildNodes();
				int cLen = cList.getLength();
				ItemVO vo = new ItemVO();
				for (int j=0; j < cLen; j++) {
					Node cNode = cList.item(j);
					String cName = cNode.getNodeName();
					if(cName.equals("#text")) continue;
//					System.out.println(cName + " : " + cNode.getTextContent());
					switch(cName) {
					case "answerCount":
						vo.setAnswerCount(cNode.getTextContent());
						break;
					case "description":
						vo.setDescription(cNode.getTextContent());
						break;
					case "pubDate":
						vo.setPubDate(cNode.getTextContent());
						break;
					case "title":
						vo.setTitle(cNode.getTextContent());
						break;
					case "link":
						vo.setLink(cNode.getTextContent());
						break;
					case "category":
						vo.setCategory(cNode.getTextContent());
						break;
					}
				}
				items.add(vo);
			}
			for (ItemVO item : items) {
				System.out.println(item.getAnswerCount());
				System.out.println(item.getDescription());
				System.out.println(item.getPubDate());
				System.out.println(item.getTitle());
				System.out.println(item.getLink());
				System.out.println(item.getCategory());
				System.out.println("");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
