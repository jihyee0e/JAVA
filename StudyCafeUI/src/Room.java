import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Room { // 방 클래스
	// 멤버변수
	private String roomname; //방 이름 나타낸 변수
	private Boolean used; //방의 사용 유무를 나타낸 변수
	private int count;  //방 인원 수를 나타낸 변수
	private int payment;  //가격을 나타낸 변수
	private User guser;  //방의 이용자를 나타낸 변수
	private int pay;
	
	private long checkintime;   //체크인 시간
	private long checkouttime;  //체크아웃 시간
	
	Calendar today = Calendar.getInstance(); 
	
	//Room 생성자
	public Room(String roomname, Boolean used, int count, User guser, int payment) {
		this.roomname = roomname; 
		this.used = used; 
		this.count = count;
		this.guser = guser; 
		this.payment = payment; 
	}
	
	//데이터를 읽어오는 생성자
	public Room(ObjectInputStream in) throws Exception {
		roomdatainput(in);
	}
	
	//검색용으로 필요한 방 객체를 만들기 위한 생성자
	public Room(String roomname) {
		this.roomname = roomname;
	}
	
	public String getRoomname() {
		return roomname; 
	}
	
	public Boolean getUsed() {
		return used; 
	}
	
	public int getCount() { 
		return count;
	}
	
	public int getPayment() { 
		return payment; 
	}
	
	public User getGuser() {
		return guser; 
	}
	
	public void setPrice(int payment) {
		this.payment = payment;  
	}
	
	public void setRoomname(String roomname) { 
		this.roomname = roomname; 
	}
	
	//체크인, 체크아웃 메소드
	//체크인 set, get 함수
	void setCheckintime() {
		today.setTimeInMillis(System.currentTimeMillis());
		
		checkintime = today.getTimeInMillis();
	}
	long getCheckintime() {
		return checkintime;
	}
	
	//체크인 함수
	public void checkin(User guser) { 
		used = true; 
		this.guser = guser;
		
		setCheckintime();
	}
	
	//체크아웃
	//체크아웃 set, get 함수
	void setCheckouttime() {
		today.setTimeInMillis(System.currentTimeMillis());
			
		checkouttime = today.getTimeInMillis();
	}
	long getCheckouttime() {
		return checkouttime;
	}
		
	//체크아웃 함수
	public void checkout() {
		used = false; 
		this.guser = null; 
	}
	
	//시간 당 가격 set, get 함수
	void setPay(int pay) {
		this.pay = pay;
	}
	int getPay() {
		return pay;
	}

	//pay; 시간 당 가격 
	//0~29까지는 x, 30분 이상부터는 1시간으로 처리(초 생각x)
	int payment() { 
		int totaltime = 0;  //전체 시간
			
		long timeminute = (checkouttime - checkintime) / (1000 * 60);
		long timehour = (checkouttime - checkintime) / (1000 * 60 * 60);
			
		if(timeminute >= 30) {  //이용시간이 30분 넘었을 때
			totaltime += 1;  //1시간으로 간주하여 +1시간
			if(timehour >= 1) {  
				totaltime += timehour;  //전체시간은 공부한 시간만큼 누적
			}
			payment = totaltime * pay;
		}
		else {  //30분 미만일 경우
			payment = pay;  //분 당 가격으로 지불 금액 책정
		
		}
		return payment;
	}
	
	
	private void roomdatainput(ObjectInputStream in) throws Exception
	{
		try {
			roomname = ((DataInput) in).readUTF();  //방의 이름 데이터
			count = ((DataInput) in).readInt();  //방의 인원수 데이터
			payment = ((DataInput) in).readInt();  //가격 데이터
			used = ((DataInput) in).readBoolean();  //방 사용 데이터
			if (used == true) { //used == true 
				String userName = ((DataInput) in).readUTF(); //사용자의 이름 데이터
				String userPhoneNum = ((DataInput) in).readUTF(); //사용자의 전화번호 데이터
				
				guser = new User(userName, userPhoneNum);
			}
		}
		catch (IOException ioe) { 
			throw new Exception("ERROR"); 
		}
	}
	
	public void roomdataoutput(ObjectOutputStream out) throws Exception
	{
		try {
			out.writeUTF(roomname);  //방 이름 저장
			out.writeInt(count);  // 방의 인원수를 저장
			out.writeInt(payment);  //가격 저장
			out.writeBoolean(used);  //방 사용 
			if (used == true)  //현재 방을 사용
			{
				out.writeUTF(guser.getUsername()); 
				out.writeUTF(guser.getPhonenumber()); 
			}
		}
		catch (IOException ioe) { 
			throw new Exception("Can't Write"); 
		}
	}
	
	public boolean equals(Object obj) { //equals  정의
		if (!(obj instanceof Room)) { 
			return false;
		}
		
		Room room = (Room) obj; 
		if (this.roomname.equals(room.roomname)) { 
			return true;
		}
		else
		{
			return false;
		}
	}

}
