package day14.quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

	public static void copy(String src, String dest) {
		// TODO Auto-generated method stub
		File fSrc = new File(src);
		File fDest = new File(dest);
		String path = dest.substring(0, dest.lastIndexOf('/'));
		File temp = new File(path);
		if(!temp.exists()) {
			temp.mkdirs();
		}
		String fileName = src.substring(src.lastIndexOf('/')+1);
		if(fDest.isDirectory()){
			
			fDest = new File(dest+"/"+fileName);
		}
			try(
					FileReader fr = new FileReader(fSrc);
					FileWriter fw = new FileWriter(fDest);
					
					) {
				while (true) {
					char[] buffer = new char[1024];
					int len = fr.read(buffer);
					
					if (len == -1) break;
					fw.write(buffer, 0, len);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

}
