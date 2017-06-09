package day15;

public class Product {
	private String company;
	private String name;
	private String no;
	private long price;
	public Product(String company, String name, String no, long price) {
		super();
		this.company = company;
		this.name = name;
		this.no = no;
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public boolean comparePrince(long s, long e) {
		if (price >= s && price <= e) return true;
		return false;
	}
	
	public boolean compareName(String name) {
		if (this.name.contains(name)) return true;
		return false;
	}
	
	public String toString() {
		return String.format("%s\t%s\t%s\t%d 원", 
						company, name, no, price);
	}
	
}
