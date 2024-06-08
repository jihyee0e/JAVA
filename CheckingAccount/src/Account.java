class Account {
    String accountNo;  //계좌번호
    String ownerName;  //예금주 이름
    int balance;  //잔액

    //3개의 파라미터를 받는 Account생성자
    Account(String accountNo, String ownerName, int balance) {
    	this.accountNo = accountNo;
    	this.ownerName = ownerName;
    	this.balance = balance;
    }
    
    void deposit(int amount) {  //예금 기능을 구현하는 메소드 선언
        balance += amount;
    }
    
    int withdraw(int amount) throws Exception {  //인출 기능 구현 메소드
        if (balance < amount)
            throw new Exception("잔액이 부족합니다.");
        balance -= amount;
        return amount;
    }
    
    //account get, set변수
    String getAccountNo() {
    	return accountNo;
    }
    void setAccountNo(String accountNo) {
    	this.accountNo = accountNo;
    }
    
    //ownerName get, set변수
    String getOwnerName() {
    	return ownerName;
    }
    void setOwnerName(String ownerName) {
    	this.ownerName = ownerName;
    }
    
    //balance get, set변수
    int getBalance() {
    	return balance;
    }
    void setBalance(int balance) {
    	this.balance = balance;
    }
}