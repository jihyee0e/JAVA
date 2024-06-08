//ComputeArea.java
//원의 면적 계산하기

import java.util.Scanner;
public class ComputerArea {
    public static void main(String[] args) {
        //변수 선언
        final double PI = 3.14159;
        double radius, area;

        //Scanner객체
        Scanner scan = new Scanner(System.in);
        
        //원의 반지름 입력 받기
        System.out.print("원의  반지름을 입력하세요: ");
        radius = scan.nextDouble();
        
        //원의 면적
        area = PI * radius * radius;

        //원의 반지름과 면적 출력
        System.out.println("원의 반지름은 " + radius + "이다");
        System.out.println("원의 면적은 " + area + "이다");
    }
}
