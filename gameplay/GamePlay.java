//����, ����, �� ����

import java.util.Scanner;

class GamePlay  //GamePlay Ŭ���� ����
{  
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);  //Scanner��ü
        String myChoice1;  //ö���� ����
        String myChoice2;  //������ ����

        System.out.println("<ö��>");  //ö���̸� ����ϱ�
        System.out.print("����, ����, �� �� � ���� ���ðڽ��ϱ�?(ex.����): ");  //����, ����, �� �� �ϳ� �Է¹ޱ�
        myChoice1 = scan.nextLine();  //���ڿ��� �б� ���� ScannerŬ������ next()�޼ҵ� �̿�

        System.out.println("<����>");  //�����̸� ����ϱ�
        System.out.print("����, ����, �� �� � ���� ���ðڽ��ϱ�?(ex.����): ");  //����, ����, �� �� �ϳ� �Է¹ޱ�
        myChoice2 = scan.nextLine();  //���ڿ��� �б� ���� ScannerŬ������ next()�޼ҵ� �̿�

        //ö���� ������ ���� ��
        if(myChoice2.equals("����"))  //����=����(ö��=����)
        {
            System.out.println("ö���� ����� ���� " + myChoice1 + "�� �����Ƿ� �����ϴ�.");
        }
        else if(myChoice2.equals("��"))  //����>��(ö��>����)
        {
            System.out.println("ö���� " + myChoice1 + "�� �̰���ϴ�.");
        }
        else if(myChoice2.equals("����"))  //����<����(ö��<����)
        {
            System.out.println("���� " + myChoice2 + "�� �̰���ϴ�.");
        }

        //ö���� ������ ���� ��
        else if(myChoice2.equals("����"))  //����=����(ö��=����)
        {
            System.out.println("ö���� ����� ���� " + myChoice1 + "�� �����Ƿ� �����ϴ�.");
        }
        else if(myChoice2.equals("����"))  //����>����(ö��>����)
        {
            System.out.println("ö���� " + myChoice1 + "�� �̰���ϴ�.");
        }
        else if(myChoice2.equals("��"))  //����<��(ö��<����)
        {
            System.out.println("���� " + myChoice2 + "�� �̰���ϴ�.");
        }
          
        //ö���� ���� ���� ��
        else if(myChoice2.equals("��"))  //��=��(ö��=����)
        {
            System.out.println("ö���� ����� ���� " + myChoice1 + "�� �����Ƿ� �����ϴ�.");
        }
        else if(myChoice2.equals("����"))  //��>����(ö��>����)
        {
            System.out.println("ö���� " + myChoice1 + "�� �̰���ϴ�.");
        }
        else if(myChoice2.equals("����"))  //��<����(ö��<����)
        {
            System.out.println("���� " + myChoice2 + "�� �̰���ϴ�.");
        }
    }             
}




