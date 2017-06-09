package day15;

import java.io.FileNotFoundException;

public class ProductMain {
	public static void main(String[] args) {
		try {
			ProductService service = new ProductService("iodata/product.txt");
			service.service();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
