//ComputeArea.java
//���� ���� ����ϱ�

import java.util.Scanner;
public class ComputerArea {
    public static void main(String[] args) {
        //���� ����
        final double PI = 3.14159;
        double radius, area;

        //Scanner��ü
        Scanner scan = new Scanner(System.in);
        
        //���� ������ �Է� �ޱ�
        System.out.print("����  �������� �Է��ϼ���: ");
        radius = scan.nextDouble();
        
        //���� ����
        area = PI * radius * radius;

        //���� �������� ���� ���
        System.out.println("���� �������� " + radius + "�̴�");
        System.out.println("���� ������ " + area + "�̴�");
    }
}
