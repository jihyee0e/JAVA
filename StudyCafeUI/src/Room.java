import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Room { // �� Ŭ����
	// �������
	private String roomname; //�� �̸� ��Ÿ�� ����
	private Boolean used; //���� ��� ������ ��Ÿ�� ����
	private int count;  //�� �ο� ���� ��Ÿ�� ����
	private int payment;  //������ ��Ÿ�� ����
	private User guser;  //���� �̿��ڸ� ��Ÿ�� ����
	private int pay;
	
	private long checkintime;   //üũ�� �ð�
	private long checkouttime;  //üũ�ƿ� �ð�
	
	Calendar today = Calendar.getInstance(); 
	
	//Room ������
	public Room(String roomname, Boolean used, int count, User guser, int payment) {
		this.roomname = roomname; 
		this.used = used; 
		this.count = count;
		this.guser = guser; 
		this.payment = payment; 
	}
	
	//�����͸� �о���� ������
	public Room(ObjectInputStream in) throws Exception {
		roomdatainput(in);
	}
	
	//�˻������� �ʿ��� �� ��ü�� ����� ���� ������
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
	
	//üũ��, üũ�ƿ� �޼ҵ�
	//üũ�� set, get �Լ�
	void setCheckintime() {
		today.setTimeInMillis(System.currentTimeMillis());
		
		checkintime = today.getTimeInMillis();
	}
	long getCheckintime() {
		return checkintime;
	}
	
	//üũ�� �Լ�
	public void checkin(User guser) { 
		used = true; 
		this.guser = guser;
		
		setCheckintime();
	}
	
	//üũ�ƿ�
	//üũ�ƿ� set, get �Լ�
	void setCheckouttime() {
		today.setTimeInMillis(System.currentTimeMillis());
			
		checkouttime = today.getTimeInMillis();
	}
	long getCheckouttime() {
		return checkouttime;
	}
		
	//üũ�ƿ� �Լ�
	public void checkout() {
		used = false; 
		this.guser = null; 
	}
	
	//�ð� �� ���� set, get �Լ�
	void setPay(int pay) {
		this.pay = pay;
	}
	int getPay() {
		return pay;
	}

	//pay; �ð� �� ���� 
	//0~29������ x, 30�� �̻���ʹ� 1�ð����� ó��(�� ����x)
	int payment() { 
		int totaltime = 0;  //��ü �ð�
			
		long timeminute = (checkouttime - checkintime) / (1000 * 60);
		long timehour = (checkouttime - checkintime) / (1000 * 60 * 60);
			
		if(timeminute >= 30) {  //�̿�ð��� 30�� �Ѿ��� ��
			totaltime += 1;  //1�ð����� �����Ͽ� +1�ð�
			if(timehour >= 1) {  
				totaltime += timehour;  //��ü�ð��� ������ �ð���ŭ ����
			}
			payment = totaltime * pay;
		}
		else {  //30�� �̸��� ���
			payment = pay;  //�� �� �������� ���� �ݾ� å��
		
		}
		return payment;
	}
	
	
	private void roomdatainput(ObjectInputStream in) throws Exception
	{
		try {
			roomname = ((DataInput) in).readUTF();  //���� �̸� ������
			count = ((DataInput) in).readInt();  //���� �ο��� ������
			payment = ((DataInput) in).readInt();  //���� ������
			used = ((DataInput) in).readBoolean();  //�� ��� ������
			if (used == true) { //used == true 
				String userName = ((DataInput) in).readUTF(); //������� �̸� ������
				String userPhoneNum = ((DataInput) in).readUTF(); //������� ��ȭ��ȣ ������
				
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
			out.writeUTF(roomname);  //�� �̸� ����
			out.writeInt(count);  // ���� �ο����� ����
			out.writeInt(payment);  //���� ����
			out.writeBoolean(used);  //�� ��� 
			if (used == true)  //���� ���� ���
			{
				out.writeUTF(guser.getUsername()); 
				out.writeUTF(guser.getPhonenumber()); 
			}
		}
		catch (IOException ioe) { 
			throw new Exception("Can't Write"); 
		}
	}
	
	public boolean equals(Object obj) { //equals  ����
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
