import java.util.Scanner;
import java.util.InputMismatchException;

public class MainExample1 {
	private static Scanner scan = new Scanner(System.in);
    
	public static void main(String args[]) {
		CheckingAccount obj = new CheckingAccount("111-22-33333333",
				"ȫ�浿", 0, "5555-6666-7777-8888");

    	int blank;
    	boolean end = false;
    	
    	while(true) {
    		try {
    			System.out.println("#��ȣ�� �Է��ϼ���(1.����, 2.����, 3.ī������, 4.����): ");
    			int num = scan.nextInt();

    			switch(num) {
    			case 1:  //������ ���
    				System.out.println("������ �ݾ��� �Է��ϼ���: ");
    				blank = scan.nextInt();  //������ �ݾ� �Է¹ޱ�
    				obj.deposit(blank);  //AccountŬ�������� deposit�޼ҵ� �ҷ�����
    				System.out.println("�ܾ�: " + obj.balance);
    				break;
    			case 2:  //������ ���
    			    System.out.println("������ �ݾ��� �Է��ϼ���: ");
    				blank = scan.nextInt();  //������ �ݾ� �Է¹ޱ�
    		        obj.withdraw(blank);  //AccountŬ�������� withdraw�޼ҵ� �ҷ�����
    		        System.out.println("�ܾ�: " + obj.balance);
    				break;
    			case 3:  //ī�� ������ ���
    				System.out.println("���Ҿ��� �Է��ϼ���: ");
    				blank = scan.nextInt();  //���Ҿ� �Է� �ޱ�
    				
    			    int paidAmount = obj.pay(obj.getCardNo(), blank);  //CheckintAccountŬ�������� pay�޼ҵ� �ҷ�����
    				System.out.println("�ܾ�: " + obj.balance);
    				break;
    			case 4:  //������ ���
    				end = true;
        			break;	//switch�� Ż�� �뵵
    			default:  //1~4 �̿��� ������ ���
    				System.out.println("�߸� �����̽��ϴ�. �ٽ� �Է����ּ���");
    				continue;
    			}
    			if(end == true) {
    				System.out.println("����Ǿ����ϴ�.");
    				break;
    			}
    		}
    		
    		catch (InputMismatchException ae) {  //���ڿ��� �Է¹޾��� �� ����ó��
    			System.out.println("�߸� �����̽��ϴ�. �ٽ� �Է����ּ���.");
    			scan = new Scanner(System.in);  //���ѹݺ��� �������� ���ʱ�ȭ
    		}

    		catch (Exception e) {  //��� ���� ��Ȳó��
    			String msg = e.getMessage();
    		    System.out.println(msg);
    		}
        }
    }
}