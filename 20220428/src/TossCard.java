
public class TossCard extends Card{
	private final String company = "Toss"; 
	private String cardStaff;

	Card card = new Card();
	
	public TossCard(String cardNo, String validDate, int cvc, String cardStaff, Card card) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		this.card = card;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card No, " + card.getCardNo());
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}
}
