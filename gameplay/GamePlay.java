//가위, 바위, 보 게임

import java.util.Scanner;

class GamePlay  //GamePlay 클래스 생성
{  
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);  //Scanner객체
        String myChoice1;  //철수의 선택
        String myChoice2;  //영희의 선택

        System.out.println("<철수>");  //철수이름 출력하기
        System.out.print("가위, 바위, 보 중 어떤 것을 내시겠습니까?(ex.가위): ");  //가위, 바위, 보 중 하나 입력받기
        myChoice1 = scan.nextLine();  //문자열을 읽기 위한 Scanner클래스의 next()메소드 이용

        System.out.println("<영희>");  //영희이름 출력하기
        System.out.print("가위, 바위, 보 중 어떤 것을 내시겠습니까?(ex.가위): ");  //가위, 바위, 보 중 하나 입력받기
        myChoice2 = scan.nextLine();  //문자열을 읽기 위한 Scanner클래스의 next()메소드 이용

        //철수가 가위를 냈을 때
        if(myChoice2.equals("가위"))  //가위=가위(철수=영희)
        {
            System.out.println("철수와 영희는 서로 " + myChoice1 + "를 냈으므로 비겼습니다.");
        }
        else if(myChoice2.equals("보"))  //가위>보(철수>영희)
        {
            System.out.println("철수가 " + myChoice1 + "로 이겼습니다.");
        }
        else if(myChoice2.equals("바위"))  //가위<바위(철수<영희)
        {
            System.out.println("영희가 " + myChoice2 + "로 이겼습니다.");
        }

        //철수가 바위를 냈을 때
        else if(myChoice2.equals("바위"))  //바위=바위(철수=영희)
        {
            System.out.println("철수와 영희는 서로 " + myChoice1 + "를 냈으므로 비겼습니다.");
        }
        else if(myChoice2.equals("가위"))  //바위>가위(철수>영희)
        {
            System.out.println("철수가 " + myChoice1 + "로 이겼습니다.");
        }
        else if(myChoice2.equals("보"))  //바위<보(철수<영희)
        {
            System.out.println("영희가 " + myChoice2 + "로 이겼습니다.");
        }
          
        //철수가 보를 냈을 때
        else if(myChoice2.equals("보"))  //보=보(철수=영희)
        {
            System.out.println("철수와 영희는 서로 " + myChoice1 + "를 냈으므로 비겼습니다.");
        }
        else if(myChoice2.equals("바위"))  //보>바위(철수>영희)
        {
            System.out.println("철수가 " + myChoice1 + "로 이겼습니다.");
        }
        else if(myChoice2.equals("가위"))  //보<가위(철수<영희)
        {
            System.out.println("영희가 " + myChoice2 + "로 이겼습니다.");
        }
    }             
}




