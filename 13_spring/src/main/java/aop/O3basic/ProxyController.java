package aop.O3basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProxyController implements Controller {

	private Controller controller;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public ProxyController(Controller controller) {
		this.controller = controller;
	}
	@Override
	public void service() throws Exception {
		String clzName = controller.getClass().getName();
		System.out.println(clzName + ".execute 메서드 호출시간 :" + sdf.format(new Date()));
		
		controller.service();
		
	}

}
