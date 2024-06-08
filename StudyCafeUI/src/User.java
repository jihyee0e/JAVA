public class User {
	String username;  //사용자 이름
	String phonenumber;  //사용자 전화번호
	
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
	
	//사용자 이름(username) set, get 함수
	void setUsername(String username) {
		this.username = username;
	}
	String getUsername() {
		return username;
	}
	
	//사용자 전화번호(phonenumber) set, get 함수
	void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	String getPhonenumber() {
		return phonenumber;
	}	
}
