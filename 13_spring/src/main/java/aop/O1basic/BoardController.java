package aop.O1basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BoardController implements Controller {

	@Override
	public void service() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("BoardController.execute 메서드 호출시간 :" + sdf.format(new Date()));
		System.out.println("게시판 핵심 기능 수행");
		Random r = new Random();
		for (int i=0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
		System.out.println("게시판 핵심 기능 수행 종료");
	}

}
