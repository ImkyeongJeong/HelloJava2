
public class DGBCard extends Card{
	private final String company = "대구은행"; 	
	private String cardStaff;
	
	Card card = new Card();
	
	public DGBCard(String cardNo, String validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 (Card No : " + card.getCardNo() + ", 유효기간 : " + card.getValidDate() + ", CVC : " + card.getCvc() + " )");
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}
}
