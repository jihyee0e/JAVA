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
			System.out.println("파일이 존재하지 않습니다.");
		} catch(Exception e) {
			String message = e.getMessage();
			if(message.equals("ERROR"))
			{
				System.out.println("오류가 발생했습니다.");
			}
		}
		
		//사용자 객체
		User user = new User("고지혜", "010-1111-1111");
		
		//Scanner 설정
		Scanner scan = new Scanner(System.in);
		
		try {
			int modeNumber;  //스터디 카페 모드 선택 변수
			
			boolean finalmode = false;  //모드 변경 변수
			boolean usermode = false;  //사용자 모드 변수
			boolean managermode = false;  //관리자 모드 변수
			
			while(!finalmode) {
				System.out.println("#WELCOME");
			    System.out.println("SELECT MODE NUMBER");
				System.out.println("1)사용자, 2)관리자, 3)나가기");
				
				//모드
				boolean end = false;
				while(!end) {
					try {
						System.out.println("> ");  //모드 선택받기
						modeNumber = scan.nextInt();
						
						switch(modeNumber) {  //모드 선택하기
						case 1:  //사용자 모드
							usermode = true;
							end = true;
							break;
						case 2:  //관리자 모드
							managermode = true;
							end = true;
							break;
						case 3:  //종료
							System.out.println("THANK YOU.");
							end = true;
							finalmode = true;
							break;
						default:  //1, 2, 3 숫자 이외에 다른 숫자를 입력했을 경우
							System.out.println("다시 입력해주세요.");
							break;
						}
					} catch (InputMismatchException e) {
						scan = new Scanner(System.in);	
						System.out.println("숫자만 입력해주세요.");
					} catch (Exception ex) {
						System.out.println(ex.toString());
					}
				}
				
				//1)사용자 모드를 선택했을 경우				
				while(usermode) { 
					
					int roomsize;  //스터디룸 크기
 					String username;
					
					//USER MODE
 					try {
						System.out.println("####Menu####");
						System.out.println("1. 빈 방 찾기");
						System.out.println("2. 방 사용(체크인)");
						System.out.println("3. 방 삭제(체크아웃)");
						System.out.println("4. 나가기");
						System.out.println("5. 모드 설정으로 돌아가기");
						System.out.print("> ");
						int usermenunum = scan.nextInt();  //menu 선택하기
													
						switch(usermenunum) {
						case 1:  //방 찾기
							System.out.println("1. 빈 방 찾기");
							System.out.println("방 사이즈를 선택하세요.");
							System.out.println("1)1인실, 2)2인실, 4)4인실 (ex.4)");
							System.out.println("> ");
							roomsize = scan.nextInt();
							
							ArrayList<Room> emptyroomlist;  //빈 방 리스트
							int count = roomsize;
							
							try {
								emptyroomlist = management.searchroom(count);
								System.out.println("#EMPTY ROOM LIST");
								
								int cnt = emptyroomlist.size();  //리스트 크기 변수
								for(int i = 0; i < cnt; i++) { //length만큼 반복
									System.out.println("" + emptyroomlist.get(i).getRoomname() +", 이용할 수 있는 인원:" + emptyroomlist.get(i).getCount()
											+ "시간 당 가격: " + emptyroomlist.get(i).getPay() + "원");
								}
								System.out.println();	
							} catch(InputMismatchException ime) {
								scan.nextLine();
								System.out.println("1, 2, 4 중 하나의 숫자만 입력해주세요.");
							} catch(Exception e) {
								String message1 = e.getMessage();
								if(message1.equals("NO")) {
									System.out.println("빈 방이 없습니다.");
								}
								System.out.println();
							}
							break;	   
					
						case 2:  // 방 사용(체크인)
							System.out.println();
							System.out.println("사용할 방의 이름을 입력하세요.: ");
							String checkinroomname;
							
							try 
							{
								scan.nextLine();
								checkinroomname = scan.nextLine();
								Room isusedroom = management.checkin(checkinroomname, user);
								System.out.println("방 이름: " + isusedroom.getRoomname() + "이용인원: " + isusedroom.getCount() + 
										"이용자: " + isusedroom.getGuser().getUsername() + "시간당 가격: " + isusedroom.getPayment());
							} catch(InputMismatchException ime) {
								scan.nextLine();
								System.out.println("1, 2, 4 중 하나의 숫자만 입력해주세요.");
							} catch(Exception e) {
								String message1 = e.getMessage();
								if(message1.equals("Not Exist")) {
									System.out.println("빈 방이 없습니다.");
								}
								System.out.println();
							}
							break;
							
						case 3:  //방 삭제(checkout)
							System.out.println();
							System.out.print("checkout할 방의 이름을 입력하세요: ");
							String checkoutroomname;
							
							try 
							{
								scan.nextLine();
								checkoutroomname = scan.nextLine();
								Room isusedroom = management.checkout(checkoutroomname);
								
								int pay = management.pay(checkoutroomname);
								management.setMonthpay(pay);
								
								System.out.println(checkoutroomname + "방\n" + pay);
							} catch(InputMismatchException ime) {
								scan.nextLine();
								System.out.println("1, 2, 4 중 하나의 숫자만 입력해주세요.");
							} catch(Exception e) {
								String message1 = e.getMessage();
								if(message1.equals("Not Exist")) {
									System.out.println("빈 방이 없습니다.");
								}
								System.out.println();
							}
							break;
							
						case 4:  //나가기
							System.out.println("감사합니다.");							
							usermode = false;
							finalmode = true;
							break;
							
						case 5:  //메인으로 돌아가기							
							usermode = false;
							break;
							
						default:  //1~4 외에 다른 숫자 선택했을 떄
							System.out.println("다시 입력해주세요.");
							break;
						}
						System.out.println();
					} 
					catch (InputMismatchException e) {
						scan = new Scanner(System.in);	
						System.out.println("숫자만 입력해주세요.");
					} catch (Exception ex) {
						scan = new Scanner(System.in);
						System.out.println(ex.getMessage());
					}
				}
				
				//2)관리자 모드를 선택했을 경우
				//boolean managerend = false;  //관리자 모드 빠져나가기
			    while(managermode) {
					// manager비밀번호 입력
					System.out.println("#관리자 확인을 위한 비밀번호를 입력하세요.");
					System.out.print("> ");
					scan.nextLine();
					int number = scan.nextInt();
					
					//관리자 확인
					if(management.getManagerpassword() == number) {
						boolean welcome = true;
						
						//MANAGER MODE
						while(welcome) {
							try {
								System.out.println("####Menu####");
								System.out.println("1. 방 생성");
								System.out.println("2. 방 삭제");
								System.out.println("3. 전체 방 조회");
								System.out.println("4. 나가기");
								System.out.println("5. 모드 설정으로 돌아가기");
								System.out.print("> ");
								scan = new Scanner(System.in);
								int managermenunum = scan.nextInt();  //menu 선택하기
								
								int roomnumber;  //방 번호
								int price;  //시간당 가격
								String managername;
								
								switch(managermenunum) {
								case 1:  //방 생성
									System.out.println("1. 방 생성");
									System.out.println("스터디룸 번호(ex.1 or 2 or 4):");
									roomnumber = scan.nextInt();
									System.out.println("시간 당 가격");
									price = scan.nextInt();
									
									try 
									{
										scan.nextLine();
										System.out.print("방 이름을 입력하세요.");
										
										managername = scan.nextLine();
										management.plusroom(roomnumber, managername);
										System.out.println("현재 방\n4인용 방 " + management.countfourroom() + "개\n2인용 방 " + management.counttworoom() + 
												"개\n1인용 방 " + management.countoneroom());
									} catch (InputMismatchException ime) {
										scan.nextLine();
										System.out.println("1, 2, 4 중 하나의 숫자를 입력해주세요.");
										System.out.println();
									} catch (NoSuchElementException nsee) {
										System.out.println("방의 이름을 입력하세요.");
										System.out.println();
									} catch(Exception e) {
										String message2 = e.getMessage();
										if(message2.equals("Retry")) {
											System.out.println("1, 2, 4 중 하나의 숫자를 입력해주세요.");
										}
										System.out.println();
									}
									break;
												
								case 2:  // 방 삭제
									System.out.println();
									System.out.print("어떤 방을 삭제하시겠습니까? 방의 이름을 입력하세요.");
									String deleteroomname;
									
									try 
									{
										scan.nextLine();
										deleteroomname = scan.nextLine();
										management.deleteroom(deleteroomname);
										
										System.out.println("현재 방\n4인용 방 " + management.countfourroom().size() + 
												"개\n2인용 방 " + management.counttworoom().size() + "개\n1인용 방 " + management.countoneroom().size());
									} catch (NoSuchElementException nsee) {
										System.out.println("방의 이름을 입력하세요.");
										System.out.println();
									} catch(Exception e) {
										String message3 = e.getMessage();
										if(message3.equals("Not Exist")) {
											System.out.println("NOT");
										}
										System.out.println();
									}
									break;
									
								case 3:  //전체 방 조회
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
									
									//사용 중인 전체 방 조회
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
								case 4:  //나가기
									System.out.println("종료되었습니다.");
									managermode = true;
									welcome = false;
									finalmode = true;
									break;
									
								case 5:  //메인 설정으로 돌아가기
									managermode = false;
									welcome = false;
									break;
									
								default:  //1~4 외에 다른 숫자 선택했을 떄
									System.out.println("다시 입력해주세요.");
									break;
								}
							} catch (InputMismatchException e) {
								scan = new Scanner(System.in);	
								System.out.println("숫자만 입력해주세요.");
							} catch (Exception ex) {
								scan = new Scanner(System.in);
								System.out.println(ex.getMessage());
							}
						}
					}
					else {  //manager 비밀번호가 틀렸을 때
						System.out.println("비밀번호가 일치하지 않습니다.");
						managermode = false;
					}
				}
			}
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
		scan.close();
		
		/*
		//데이터 저장
		data.writecount(management.getCount());
		data.writeroom(management.getroom(), management.getCount());
		*/
	}
		
}