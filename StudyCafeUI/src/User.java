public class User {
	String username;  //����� �̸�
	String phonenumber;  //����� ��ȭ��ȣ
	
	/*
	User() {
		this.username = "";
		this.phonenumber = "";
	}
	*/
	
	User(String username, String phonenumber) {
		this.username = username;
		this.phonenumber = phonenumber;
	}
	
	//����� �̸�(username) set, get �Լ�
	void setUsername(String username) {
		this.username = username;
	}
	String getUsername() {
		return username;
	}
	
	//����� ��ȭ��ȣ(phonenumber) set, get �Լ�
	void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	String getPhonenumber() {
		return phonenumber;
	}	
}
