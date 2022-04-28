
public class SimplePayment implements Payment{
	private double simplePaymentRatio;

	public SimplePayment(double simplePaymentRatio) {
		super();
		this.simplePaymentRatio = simplePaymentRatio;
	}

	@Override
	public int online(int price) {
		int online = price - ((int) (price * (ONLINE_PAYMENT_RATIO + simplePaymentRatio)));
		return online;
	}

	@Override
	public int offline(int price) {
		int offline = price - ((int) (price * (OFFLINE_PAYMENT_RATIO + simplePaymentRatio)));
		return offline;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제시 총 할인율 : " + (simplePaymentRatio+ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제시 총 할인율 : "+ (simplePaymentRatio+OFFLINE_PAYMENT_RATIO));
	}
	
	
}
