package day11.exam;

public class CardPayment extends Payment{
	private String cardNumber;
	private String cardPassword;
	private int monthlyInstallment;
	
	public CardPayment(String shopName,
						String productName,
						long productPrice,
						String cardNumber,
						String cardPassword,
						int monthlyInstallment) {
		super(shopName, productName, productPrice);
		this.cardNumber = cardNumber;
		this.cardPassword = cardPassword;
		this.monthlyInstallment = monthlyInstallment;
		
	}
	
	public String toString() {
		return String.format("[신용카드 결제 정보]\n상점명 : %s\n상품명 : %s\n"
				+"상품가격 : %d\n신용카드번호 : %s\n할부개월 : %d"
				, shopName, productName, productPrice, cardNumber, monthlyInstallment );
	}

	@Override
	public void pay() throws PayException {
		// TODO Auto-generated method stub
		if (productPrice < 1 || monthlyInstallment <0) throw new PayException("가격이나 할부개월수가 잘못되었습니다.");
		System.out.println("신용카드가 정상적으로 지불되었습니다.");
	}
}
