class Account {
    String accountNo;  //���¹�ȣ
    String ownerName;  //������ �̸�
    int balance;  //�ܾ�

    //3���� �Ķ���͸� �޴� Account������
    Account(String accountNo, String ownerName, int balance) {
    	this.accountNo = accountNo;
    	this.ownerName = ownerName;
    	this.balance = balance;
    }
    
    void deposit(int amount) {  //���� ����� �����ϴ� �޼ҵ� ����
        balance += amount;
    }
    
    int withdraw(int amount) throws Exception {  //���� ��� ���� �޼ҵ�
        if (balance < amount)
            throw new Exception("�ܾ��� �����մϴ�.");
        balance -= amount;
        return amount;
    }
    
    //account get, set����
    String getAccountNo() {
    	return accountNo;
    }
    void setAccountNo(String accountNo) {
    	this.accountNo = accountNo;
    }
    
    //ownerName get, set����
    String getOwnerName() {
    	return ownerName;
    }
    void setOwnerName(String ownerName) {
    	this.ownerName = ownerName;
    }
    
    //balance get, set����
    int getBalance() {
    	return balance;
    }
    void setBalance(int balance) {
    	this.balance = balance;
    }
}