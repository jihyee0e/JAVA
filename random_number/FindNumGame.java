//1���� 100������ �߻��� ������ ���ڸ� 5���ȿ� ���ߴ� ����.
import java.util.Scanner;
import java.util.Random;

public class FindNumGame 
{
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        //Scanner��ü
        Scanner scan = new Scanner(System.in);

        Random ranGen = new Random();
        int ranNum, answer, count=1;

        //0���� 99���� ������ �����ѹ� �߻��ϹǷ� +1�� �Ͽ� 1���� 100������ �����ѹ� ����
        ranNum=ranGen.nextInt(100)+1;
 
        while(count<6) 
        {
            // ���⸦ ä�켼��
            // �Է��� ���ڿ� �������� ���ؼ� ������ ū���� ����ڿ��� �˷��ش�
            //  ������� ������� ������ ���߾����ϴ�  ��� ǥ�� �� ����
  
            //���� �Է�
            System.out.print("���ڸ� �Է��ϼ���(1~100): ");
            answer = scan.nextInt();

            //�Է��� ���ڰ� ���� ���ں��� Ŭ ��
            if (ranNum > answer) {
                System.out.print("�Է��� ���ں��� Ů�ϴ�.");
                count++;
            }

            //�Է��� ���ڰ� ���� ���ں��� ���� ��
            else if (ranNum < answer) {
                System.out.print("�Է��� ���ں��� �۽��ϴ�.");
                count++;
            }
 
            //�Է��� ���ڿ� ���� ���ڰ� ���� ��
            else if (ranNum == answer) {
                System.out.print(count + "������ ������ ���߾����ϴ�.");
                break;
            }
        if (count==6)
            System.out.println("������ 5�� �õ��� ������ ���߽��ϴ�.");
        }
    }
}
