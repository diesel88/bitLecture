package aop.O5anno;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("board")
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
