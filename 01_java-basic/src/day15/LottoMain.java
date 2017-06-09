package day15;

import java.io.IOException;

public class LottoMain {
	public static void main(String[] args) {
		try {
			LottoService service = new LottoService("iodata/lotto.txt");
			service.service();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
