package day11.exam;

public class CashPayment extends Payment{
	private String cashReceiptNumber;
	
	public CashPayment(String shopName,
			String productName,
			long productPrice,
			String cashReceiptNumber) {
		super(shopName, productName, productPrice);
		this.cashReceiptNumber = cashReceiptNumber;
	}
	
	public String toString() {
		return String.format("[현금 결제 정보]\n상점명 : %s\n상품명 : %s\n"
				+"상품가격 : %d\n현금영수증번호 : %s"
				, shopName, productName, productPrice, cashReceiptNumber );
	}

	@Override
	public void pay() throws PayException {
		// TODO Auto-generated method stub
		if (productPrice < 1) throw new PayException("가격이 잘못되었습니다.");
		System.out.println("현금이 정상적으로 지불되었습니다.");
	}
	
}
