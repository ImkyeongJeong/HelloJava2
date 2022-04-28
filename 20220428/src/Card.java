
public class Card {
	private String cardNo;
	private String validDate;
	private int cvc;
	
	public Card(String cardNo, String validDate, int cvc) {
		super();
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}

	public Card() {
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	
	public void showCardInfo() {
		System.out.println("카드정보 ( Card No : " + cardNo + ", 유효기간 :  " + validDate + ", CVC : " + cvc + " )");
	}
}
