import java.io.*;
import java.util.*;

import java.util.*; 
import java.io.*;

public class Management {
	private ArrayList<Room> roomarraylist = new ArrayList<Room>(); //ArrayList 변수
	private int monthpay[] = new int[12];  // 월 통계
	private int totalpayment[] = new int[31];  // 날짜별 수입
	private int fourroom;  //4인용 방 가격 변수  
	private int tworoom;  //2인용 방 가격 변수
	private int oneroom;  //1인용 방 가격 변수
	int month; int day;
	
	private int managerpassword = 0000;	 //manager password 변수
	
	//관리자 비밀번호 번환 함수
	int getManagerpassword() {
		return managerpassword;
	}
	
	private ObjectOutputStream out = null; 
	
	// 멤버함수
	Management(ObjectInputStream in) throws Exception { 
		datainput(in); 
	}
	
	Management(int fourroom, int tworoom, int oneroom) {
		this.fourroom = fourroom; 
		this.tworoom = tworoom; 
		this.oneroom = oneroom;
	}
	
	
	public ArrayList<Room> searchroom(int cnt) throws Exception{ 
		int num = roomarraylist.size(); // 방의 개수
		ArrayList<Room> emptyRoomList = new ArrayList<Room>(); 
		
		for (int i = 0; i < num; i++) { // 0부터 roomArr.length까지 반복
			if((roomarraylist.get(i).getUsed() == false) && (roomarraylist.get(i).getCount() >= cnt)) {
				emptyRoomList.add(roomarraylist.get(i)); 
			}
		}
		
		if(emptyRoomList.size() == 0) { 
			throw new Exception("Not Exist"); 
		}
		else { 
			return emptyRoomList;
		}
	}
	
	
    void plusroom(int count, String roomname) throws Exception{  
		int price;  //새로 생성될 방의 가격
		
		if(count == 4) {  //count=4
			price = fourroom;  
		}
		else if(count == 2) {  //count=2
			price = tworoom;  
		}
		else if(count == 1) {  //count=1
			price = oneroom;  
		}
		else {  
			throw new Exception("Retry");  
		}

		Room newRoom = new Room(roomname, false,count, null, price); 
		roomarraylist.add(newRoom); 
	}
	
	
	void deleteroom(String roomname) throws Exception{ 
		if (!(roomarraylist.remove(new Room(roomname)))){
			throw new Exception("Not Exist"); 
		}
	}
	
	
	Room checkin(String roomname, User user) throws Exception{ 
		int index = searchroomname(roomname);
		
		if (index == -1) { 
			throw new Exception("Not Exist"); 
		}
		else { // 해당하는 번호를 가진 방이 있을 때
			try { // 예외처리
				roomarraylist.get(index).checkin(user); 
				return roomarraylist.get(index); 
			}
			catch (IndexOutOfBoundsException IOOBE) { 
				throw new Exception("Ioobe"); 
			}
		}
	}
	
	
	Room checkout(String roomname) throws Exception { 
		int index = searchroomname(roomname);
	
		if (index == -1) {
			throw new Exception("Not Exist");
		}
		else { // 해당하는 번호를 가진 방이 있을 때
			try {
				roomarraylist.get(index).checkout(); 
				return roomarraylist.get(index); 
			}
			catch (IndexOutOfBoundsException IOOBE) { 
				throw new Exception("Ioobe");
			}
		}
		
	}
	
	
	int pay(String roomname) throws Exception { 
		int index = searchroomname(roomname);
		
		if (index == -1) { 
			throw new Exception("Not Exist"); 
		}
		else { // 해당하는 방 이름을 가진 방이 있을 때
			try { // 예외처리
				return roomarraylist.get(index).payment(); 
			}
			catch (IndexOutOfBoundsException IOOBE) { 
				throw new Exception("Ioobe");
			}
		}
	}
	
	void setPayment(int count, int payment) throws Exception { 
		if(count == 4) {  //count=4
			fourroom = payment; 
		}
		else if(count == 2) {  //count=2
			tworoom = payment; 
		}
		else if(count == 1) {  //count=1
			oneroom = payment; 
		}
		else { //count가 4, 2, 1가 아닌 경우 예외처리
			throw new Exception("Retry");
		}
		
		int num = roomarraylist.size(); //방의 개수
		
		for (int i = 0; i < num; i++) { //인원이 count인 방 찾기 
			if(roomarraylist.get(i).getCount() == count) {
				roomarraylist.get(i).setPrice(payment); 
			}
		}
	}
	
	void setMonthpay(int income) { 
		monthpay[month - 1] += income; 
	}
	
	void setTotalpayment(int income) {
		totalpayment[day - 1] += income; 
	}
	
	ArrayList<Room> getRoomlist() { 
		return roomarraylist; 
	}
	
	int getMonthpay(int month) { 
		return monthpay[month - 1]; 
	}
	
	int getTotalpayment(int day) {
		return totalpayment[day - 1]; 
	} 
	
	int getFourroom()
	{
		return fourroom;
	}
	
	int getTworoom() 
	{
		return tworoom; 
	}
	
	int getOneroom()
	{
		return oneroom;
	}
	
	int searchroomname(String roomName) { 
		return roomarraylist.indexOf(new Room(roomName));
	}
	
	ArrayList<Room> countfourroom () {
		int num = roomarraylist.size(); 
		ArrayList<Room> temRoomList = new ArrayList<Room>(); 
		
		for (int i = 0; i < num; i++) { 
			if((roomarraylist.get(i).getCount() == 8)) { 
				temRoomList.add(roomarraylist.get(i));
			}
		}
		return temRoomList; 
	}
	
	ArrayList<Room> counttworoom () { 
		int num = roomarraylist.size();
		ArrayList<Room> temRoomList = new ArrayList<Room>(); 
		
		for (int i = 0; i < num; i++) { 
			if((roomarraylist.get(i).getCount() == 4)) { 
				temRoomList.add(roomarraylist.get(i));
			}
		}
		return temRoomList; 
	}
	
	ArrayList<Room> countoneroom () { 
		int num = roomarraylist.size(); // 방의 개수
		ArrayList<Room> temRoomList = new ArrayList<Room>(); 
		
		for (int i = 0; i < num; i++) { 
			if((roomarraylist.get(i).getCount() == 2)) { 
				temRoomList.add(roomarraylist.get(i)); 
			}
		}
		return temRoomList; 
	}
	
	// 데이터를 저장하는 함수
	void dataoutput() throws Exception
	{
		try { 
			// 데이터 저장하기
			out = new ObjectOutputStream(new FileOutputStream("StudyCafeData.dat")); 
			for(int i = 0; i < 31; i++) { 
				out.writeInt(getTotalpayment(i+1));  
			}
			for(int i = 0; i < 12; i++) { 
				out.writeInt(getMonthpay(i+1)); 
			}
			out.writeInt(roomarraylist.size()); 
			out.writeInt(getFourroom()); 
			out.writeInt(getTworoom()); 
			out.writeInt(getOneroom());
			
			int num = roomarraylist.size(); 
			
			for (int i = 0; i < num; i++) 
			{
				roomarraylist.get(i).roomdataoutput(out);
			}
		}
		catch (IOException ioe) { 
			throw new Exception("Can't Write");
		}
		finally {
			try {
				out.close();
			}
			catch (Exception e) { 
			}
		}	
	}
		
	// 데이터를 읽어오는 함수
	void datainput(ObjectInputStream in) throws Exception
	{
		try { 
			for(int i = 0; i < 31; i++) {
				setPayment((i + 1), in.readInt());
			}
			
			for(int i = 0; i < 12; i++) { 
				setMonthpay((i + 1)); 
			}
			
			int num = in.readInt(); 
			
			roomarraylist = new ArrayList<Room>();
			fourroom = in.readInt(); 
			tworoom = in.readInt(); 
			oneroom = in.readInt(); 
			
			for (int i = 0; i < num; i++) {
				Room room = new Room(in);
				roomarraylist.add(room);
			}
		}
		catch (IOException ioe) { 
			throw new Exception("ERROR"); 
		}
		finally { 
			try { 
				in.close(); 
			}
			catch (Exception e) { 
			}
		}
				
	}	
}