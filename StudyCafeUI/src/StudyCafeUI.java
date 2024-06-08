import java.io.*;
import java.util.*;
import java.text.*;

import java.io.*;
import java.util.*;

public class StudyCafeUI {
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = null;
		Management management = null;
		try {
			in = new ObjectInputStream(new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\StudyCafeUI\\output2.dat"));
		    management = new Management(in);
		
		} catch(FileNotFoundException fnfe) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch(Exception e) {
			String message = e.getMessage();
			if(message.equals("ERROR"))
			{
				System.out.println("������ �߻��߽��ϴ�.");
			}
		}
		
		//����� ��ü
		User user = new User("������", "010-1111-1111");
		
		//Scanner ����
		Scanner scan = new Scanner(System.in);
		
		try {
			int modeNumber;  //���͵� ī�� ��� ���� ����
			
			boolean finalmode = false;  //��� ���� ����
			boolean usermode = false;  //����� ��� ����
			boolean managermode = false;  //������ ��� ����
			
			while(!finalmode) {
				System.out.println("#WELCOME");
			    System.out.println("SELECT MODE NUMBER");
				System.out.println("1)�����, 2)������, 3)������");
				
				//���
				boolean end = false;
				while(!end) {
					try {
						System.out.println("> ");  //��� ���ùޱ�
						modeNumber = scan.nextInt();
						
						switch(modeNumber) {  //��� �����ϱ�
						case 1:  //����� ���
							usermode = true;
							end = true;
							break;
						case 2:  //������ ���
							managermode = true;
							end = true;
							break;
						case 3:  //����
							System.out.println("THANK YOU.");
							end = true;
							finalmode = true;
							break;
						default:  //1, 2, 3 ���� �̿ܿ� �ٸ� ���ڸ� �Է����� ���
							System.out.println("�ٽ� �Է����ּ���.");
							break;
						}
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);	
						System.out.println("���ڸ� �Է����ּ���.");
					} catch (Exception ex) {
						System.out.println(ex.toString());
					}
				}
				
				//1)����� ��带 �������� ���				
				while(usermode) { 
					
					int roomsize;  //���͵�� ũ��
 					String username;
					
					//USER MODE
 					try {
						System.out.println("####Menu####");
						System.out.println("1. �� �� ã��");
						System.out.println("2. �� ���(üũ��)");
						System.out.println("3. �� ����(üũ�ƿ�)");
						System.out.println("4. ������");
						System.out.println("5. ��� �������� ���ư���");
						System.out.print("> ");
						int usermenunum = scan.nextInt();  //menu �����ϱ�
													
						switch(usermenunum) {
						case 1:  //�� ã��
							System.out.println("1. �� �� ã��");
							System.out.println("�� ����� �����ϼ���.");
							System.out.println("1)1�ν�, 2)2�ν�, 4)4�ν� (ex.4)");
							System.out.println("> ");
							roomsize = scan.nextInt();
							
							ArrayList<Room> emptyroomlist;  //�� �� ����Ʈ
							int count = roomsize;
							
							try {
								emptyroomlist = management.searchroom(count);
								System.out.println("#EMPTY ROOM LIST");
								
								int cnt = emptyroomlist.size();  //����Ʈ ũ�� ����
								for(int i = 0; i < cnt; i++) { //length��ŭ �ݺ�
									System.out.println("" + emptyroomlist.get(i).getRoomname() +", �̿��� �� �ִ� �ο�:" + emptyroomlist.get(i).getCount()
											+ "�ð� �� ����: " + emptyroomlist.get(i).getPay() + "��");
								}
								System.out.println();	
							} catch(InputMismatchException ime) {
								scan.nextLine();
								System.out.println("1, 2, 4 �� �ϳ��� ���ڸ� �Է����ּ���.");
							} catch(Exception e) {
								String message1 = e.getMessage();
								if(message1.equals("NO")) {
									System.out.println("�� ���� �����ϴ�.");
								}
								System.out.println();
							}
							break;	   
					
						case 2:  // �� ���(üũ��)
							System.out.println();
							System.out.println("����� ���� �̸��� �Է��ϼ���.: ");
							String checkinroomname;
							
							try 
							{
								scan.nextLine();
								checkinroomname = scan.nextLine();
								Room isusedroom = management.checkin(checkinroomname, user);
								System.out.println("�� �̸�: " + isusedroom.getRoomname() + "�̿��ο�: " + isusedroom.getCount() + 
										"�̿���: " + isusedroom.getGuser().getUsername() + "�ð��� ����: " + isusedroom.getPayment());
							} catch(InputMismatchException ime) {
								scan.nextLine();
								System.out.println("1, 2, 4 �� �ϳ��� ���ڸ� �Է����ּ���.");
							} catch(Exception e) {
								String message1 = e.getMessage();
								if(message1.equals("Not Exist")) {
									System.out.println("�� ���� �����ϴ�.");
								}
								System.out.println();
							}
							break;
							
						case 3:  //�� ����(checkout)
							System.out.println();
							System.out.print("checkout�� ���� �̸��� �Է��ϼ���: ");
							String checkoutroomname;
							
							try 
							{
								scan.nextLine();
								checkoutroomname = scan.nextLine();
								Room isusedroom = management.checkout(checkoutroomname);
								
								int pay = management.pay(checkoutroomname);
								management.setMonthpay(pay);
								
								System.out.println(checkoutroomname + "��\n" + pay);
							} catch(InputMismatchException ime) {
								scan.nextLine();
								System.out.println("1, 2, 4 �� �ϳ��� ���ڸ� �Է����ּ���.");
							} catch(Exception e) {
								String message1 = e.getMessage();
								if(message1.equals("Not Exist")) {
									System.out.println("�� ���� �����ϴ�.");
								}
								System.out.println();
							}
							break;
							
						case 4:  //������
							System.out.println("�����մϴ�.");							
							usermode = false;
							finalmode = true;
							break;
							
						case 5:  //�������� ���ư���							
							usermode = false;
							break;
							
						default:  //1~4 �ܿ� �ٸ� ���� �������� ��
							System.out.println("�ٽ� �Է����ּ���.");
							break;
						}
						System.out.println();
					} 
					catch (InputMismatchException e) {
						scan = new Scanner(System.in);	
						System.out.println("���ڸ� �Է����ּ���.");
					} catch (Exception ex) {
						scan = new Scanner(System.in);
						System.out.println(ex.getMessage());
					}
				}
				
				//2)������ ��带 �������� ���
				//boolean managerend = false;  //������ ��� ����������
			    while(managermode) {
					// manager��й�ȣ �Է�
					System.out.println("#������ Ȯ���� ���� ��й�ȣ�� �Է��ϼ���.");
					System.out.print("> ");
					scan.nextLine();
					int number = scan.nextInt();
					
					//������ Ȯ��
					if(management.getManagerpassword() == number) {
						boolean welcome = true;
						
						//MANAGER MODE
						while(welcome) {
							try {
								System.out.println("####Menu####");
								System.out.println("1. �� ����");
								System.out.println("2. �� ����");
								System.out.println("3. ��ü �� ��ȸ");
								System.out.println("4. ������");
								System.out.println("5. ��� �������� ���ư���");
								System.out.print("> ");
								scan = new Scanner(System.in);
								int managermenunum = scan.nextInt();  //menu �����ϱ�
								
								int roomnumber;  //�� ��ȣ
								int price;  //�ð��� ����
								String managername;
								
								switch(managermenunum) {
								case 1:  //�� ����
									System.out.println("1. �� ����");
									System.out.println("���͵�� ��ȣ(ex.1 or 2 or 4):");
									roomnumber = scan.nextInt();
									System.out.println("�ð� �� ����");
									price = scan.nextInt();
									
									try 
									{
										scan.nextLine();
										System.out.print("�� �̸��� �Է��ϼ���.");
										
										managername = scan.nextLine();
										management.plusroom(roomnumber, managername);
										System.out.println("���� ��\n4�ο� �� " + management.countfourroom() + "��\n2�ο� �� " + management.counttworoom() + 
												"��\n1�ο� �� " + management.countoneroom());
									} catch (InputMismatchException ime) {
										scan.nextLine();
										System.out.println("1, 2, 4 �� �ϳ��� ���ڸ� �Է����ּ���.");
										System.out.println();
									} catch (NoSuchElementException nsee) {
										System.out.println("���� �̸��� �Է��ϼ���.");
										System.out.println();
									} catch(Exception e) {
										String message2 = e.getMessage();
										if(message2.equals("Retry")) {
											System.out.println("1, 2, 4 �� �ϳ��� ���ڸ� �Է����ּ���.");
										}
										System.out.println();
									}
									break;
												
								case 2:  // �� ����
									System.out.println();
									System.out.print("� ���� �����Ͻðڽ��ϱ�? ���� �̸��� �Է��ϼ���.");
									String deleteroomname;
									
									try 
									{
										scan.nextLine();
										deleteroomname = scan.nextLine();
										management.deleteroom(deleteroomname);
										
										System.out.println("���� ��\n4�ο� �� " + management.countfourroom().size() + 
												"��\n2�ο� �� " + management.counttworoom().size() + "��\n1�ο� �� " + management.countoneroom().size());
									} catch (NoSuchElementException nsee) {
										System.out.println("���� �̸��� �Է��ϼ���.");
										System.out.println();
									} catch(Exception e) {
										String message3 = e.getMessage();
										if(message3.equals("Not Exist")) {
											System.out.println("NOT");
										}
										System.out.println();
									}
									break;
									
								case 3:  //��ü �� ��ȸ
									try 
									{
										management.dataoutput();
									} catch(Exception e) {
										String msg = e.getMessage();
										if(msg.equals("Can't Write")) {
											System.out.println("N'store DATA");
										}
										System.out.println();
									}
									break;
									
									//��� ���� ��ü �� ��ȸ
									/*
									Room[] roomarray = management.searchallroom();
									
									for(int i = 0; i < roomarray.length; i++) {
										Room array = roomarray[i];
										if(array == null) {
											break;
										}
										else {
											System.out.println((i+1) + "\t" + array.getRoomnumber() + 
													"\t" + array.getPay() + "\t" + array.getUsed());
										}
									}
									break;
									*/	
								case 4:  //������
									System.out.println("����Ǿ����ϴ�.");
									managermode = true;
									welcome = false;
									finalmode = true;
									break;
									
								case 5:  //���� �������� ���ư���
									managermode = false;
									welcome = false;
									break;
									
								default:  //1~4 �ܿ� �ٸ� ���� �������� ��
									System.out.println("�ٽ� �Է����ּ���.");
									break;
								}
							} catch (InputMismatchException e) {
								scan = new Scanner(System.in);	
								System.out.println("���ڸ� �Է����ּ���.");
							} catch (Exception ex) {
								scan = new Scanner(System.in);
								System.out.println(ex.getMessage());
							}
						}
					}
					else {  //manager ��й�ȣ�� Ʋ���� ��
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						managermode = false;
					}
				}
			}
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
		scan.close();
		
		/*
		//������ ����
		data.writecount(management.getCount());
		data.writeroom(management.getroom(), management.getCount());
		*/
	}
		
}