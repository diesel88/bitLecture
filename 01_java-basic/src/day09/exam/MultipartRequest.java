package day09.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MultipartRequest {
	final String HEADER = "Content-Disposition:";
	File file1, file2;
	FileOutputStream out;
	
	public MultipartRequest(){}
	public MultipartRequest(String fileName) throws IOException {
		file1 = new File(fileName);
		file2 = new File("iodata/pom.xml");
		out = new FileOutputStream(file2);
		
	}
	public String getParameter(String name) throws FileNotFoundException {
		Scanner sc = new Scanner(file1);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.startsWith(HEADER)) {
				String[] data = line.substring(HEADER.length() - 1).split(";");
				boolean flag = false;
				for (int i = 0; i < data.length; i++) {
					if (data[i].contains("name") && data[i].contains("id")) {
						flag = true;
						break;
					}
				}
				if (flag) {
					do {
						line = sc.nextLine();
						
					} while (line.length() == 0);
					return line.trim();
				}
			}
		}
		return null;
	}
	String getValue(String line, String name) {
		if (line.startsWith(HEADER)) {
			String[] data = line.substring(HEADER.length() - 1).split(";");
			for (int i = 0; i < data.length; i++) {
				if (data[i].contains(name) ) {
					return data[i].substring(data[i].indexOf('\"') + 1, data[i].lastIndexOf('\"') - 1);
				}
			}
			
		}
		return null;
	}
	public MultipartFile[] getFiles() throws FileNotFoundException {
		Scanner sc = new Scanner(file1);
		int cnt = 0;
		MultipartFile[] files = null;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String val = null;
			val = getValue(line, "name");
			System.out.println(val);
			if (val != null) {
				if (val.contains("uploadfile")) {
					val = getValue(line, "filename");
					if (val != null) {
						MultipartFile[] temp = new MultipartFile[++cnt];
						if (files != null) System.arraycopy(files, 0, temp, 0, cnt - 1);
							MultipartFile file = new MultipartFile();
							file.setName(val);
							String content = "";
							while(sc.hasNextLine()) {
								String line2 = sc.nextLine();
								if(line2.startsWith("Content-Type")) continue;
								if (line2.startsWith("-----")) {
									break;
								}
								content += line2+"\n";
							}
							file.setContent(content);
							temp[cnt -1] = file;
							files = temp;
						
					}
				}
			}
		}
		return files;
	}
}
