import java.util.Scanner;
import java.util.InputMismatchException;

public class MainExample1 {
	private static Scanner scan = new Scanner(System.in);
    
	public static void main(String args[]) {
		CheckingAccount obj = new CheckingAccount("111-22-33333333",
				"홍길동", 0, "5555-6666-7777-8888");

    	int blank;
    	boolean end = false;
    	
    	while(true) {
    		try {
    			System.out.println("#번호를 입력하세요(1.저금, 2.인출, 3.카드지불, 4.종료): ");
    			int num = scan.nextInt();

    			switch(num) {
    			case 1:  //저금인 경우
    				System.out.println("저금할 금액을 입력하세요: ");
    				blank = scan.nextInt();  //저금할 금액 입력받기
    				obj.deposit(blank);  //Account클래스에서 deposit메소드 불러오기
    				System.out.println("잔액: " + obj.balance);
    				break;
    			case 2:  //인출인 경우
    			    System.out.println("인출할 금액을 입력하세요: ");
    				blank = scan.nextInt();  //인출할 금액 입력받기
    		        obj.withdraw(blank);  //Account클래스에서 withdraw메소드 불러오기
    		        System.out.println("잔액: " + obj.balance);
    				break;
    			case 3:  //카드 지불일 경우
    				System.out.println("지불액을 입력하세요: ");
    				blank = scan.nextInt();  //지불액 입력 받기
    				
    			    int paidAmount = obj.pay(obj.getCardNo(), blank);  //CheckintAccount클래스에서 pay메소드 불러오기
    				System.out.println("잔액: " + obj.balance);
    				break;
    			case 4:  //종료일 경우
    				end = true;
        			break;	//switch문 탈출 용도
    			default:  //1~4 이외의 숫자일 경우
    				System.out.println("잘못 누르셨습니다. 다시 입력해주세요");
    				continue;
    			}
    			if(end == true) {
    				System.out.println("종료되었습니다.");
    				break;
    			}
    		}
    		
    		catch (InputMismatchException ae) {  //문자열을 입력받았을 때 예외처리
    			System.out.println("잘못 누르셨습니다. 다시 입력해주세요.");
    			scan = new Scanner(System.in);  //무한반복을 막기위해 재초기화
    		}

    		catch (Exception e) {  //모든 예외 상황처리
    			String msg = e.getMessage();
    		    System.out.println(msg);
    		}
        }
    }
}