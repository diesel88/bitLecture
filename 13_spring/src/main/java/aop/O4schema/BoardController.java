package aop.O4schema;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BoardController implements Controller {

	@Override
	public void service() throws Exception {
		
		
		System.out.println("게시판 핵심 기능 수행");
		Random r = new Random();
		for (int i=0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
		System.out.println("게시판 핵심 기능 수행 종료");
	}

}
