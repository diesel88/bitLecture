package di.O3basic;

import java.util.HashMap;
import java.util.Map;

public class TVFactory {
	public static Map<String, TV> map= new HashMap<>();
	
	static {
		map.put("lg", new LgTV());
		map.put("samsung", new SamsungTV());
	}
	
	public TV getBean(String name) {
		return map.get(name);
	}
}
