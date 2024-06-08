class CheckingAccount extends Account{  //Account클래스를 상속하는 CheckingAccount클래스 선언
	String cardNo;  //직불카드 번호
	
	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);  //슈퍼클래스 생성자 호출문; ()안에는 생성자에 넘겨지는 파라미터들
		this.cardNo = cardNo;
	}
	
	int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo) || (balance < amount))  //직불카드 사용액을 지불한다에 해당하는 메소드
			throw new Exception("지불이 불가능합니다.");
		return withdraw(amount);
	}
	
	//cardNo get, set변수
	String getCardNo() {
		return cardNo;
	}
	void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}