class CheckingAccount extends Account{  //AccountŬ������ ����ϴ� CheckingAccountŬ���� ����
	String cardNo;  //����ī�� ��ȣ
	
	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);  //����Ŭ���� ������ ȣ�⹮; ()�ȿ��� �����ڿ� �Ѱ����� �Ķ���͵�
		this.cardNo = cardNo;
	}
	
	int pay(String cardNo, int amount) throws Exception {
		if(!cardNo.equals(this.cardNo) || (balance < amount))  //����ī�� ������ �����Ѵٿ� �ش��ϴ� �޼ҵ�
			throw new Exception("������ �Ұ����մϴ�.");
		return withdraw(amount);
	}
	
	//cardNo get, set����
	String getCardNo() {
		return cardNo;
	}
	void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}