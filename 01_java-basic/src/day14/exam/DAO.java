package day14.exam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	List<VO> list = null;
	FileReader fr = null;
	FileWriter fw = null;
	String str = "";
	public DAO() throws IOException {
		list = new ArrayList<VO>();
		fr = new FileReader("src/day14/exam/person.txt");
		readData();
	}
	
	private void readData() {
		try {
			while (true) {
				char[] buffer = new char[1024];
				int len;
				len = fr.read(buffer);
				if (len == -1) {
					break;
				}
				str += String.valueOf(buffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		String[] data = str.split("\r\n");
		for (int i=0; i < data.length; i++) {
			String[] sub = data[i].split(":");
			VO vo = new VO(sub[0], sub[1]);
			list.add(vo);
		}
		
	}
	public List<VO> getByArea(String area) {
		List<VO> arr = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			VO vo = list.get(i);
			if(vo.getArea().trim().equals(area)) {
				arr.add(vo);
			}
		}
		return arr;
	}
	
	public List<VO> getByName(String name) {
		List<VO> arr = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			VO vo = list.get(i);
			if(vo.getName().startsWith(name)) {
				arr.add(vo);
			}
		}
		return arr;
	}

	public void writeFile(String str2) {
		// TODO Auto-generated method stub
		try {
			fw = new FileWriter("src/day14/exam/searchResult.txt");
			fw.write(str2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
