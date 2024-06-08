//1부터 100사이의 발생된 임의의 숫자를 5번안에 맞추는 게임.
import java.util.Scanner;
import java.util.Random;

public class FindNumGame 
{
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        //Scanner객체
        Scanner scan = new Scanner(System.in);

        Random ranGen = new Random();
        int ranNum, answer, count=1;

        //0부터 99까지 사이의 랜덤넘버 발생하므로 +1을 하여 1부터 100까지의 랜덤넘버 생성
        ranNum=ranGen.nextInt(100)+1;
 
        while(count<6) 
        {
            // 여기를 채우세요
            // 입력한 숫자와 랜덤값을 비교해서 작은가 큰가를 사용자에게 알려준다
            //  맞춘경우는 몇번만에 정답을 맞추었습니다  라고 표시 후 종료
  
            //숫자 입력
            System.out.print("숫자를 입력하세요(1~100): ");
            answer = scan.nextInt();

            //입력한 숫자가 랜덤 숫자보다 클 때
            if (ranNum > answer) {
                System.out.print("입력한 숫자보다 큽니다.");
                count++;
            }

            //입력한 숫자가 랜덤 숫자보다 작을 때
            else if (ranNum < answer) {
                System.out.print("입력한 숫자보다 작습니다.");
                count++;
            }
 
            //입력한 숫자와 랜덤 숫자가 같을 때
            else if (ranNum == answer) {
                System.out.print(count + "번만에 정답을 맞추었습니다.");
                break;
            }
        if (count==6)
            System.out.println("정답을 5번 시도에 맞추지 못했습니다.");
        }
    }
}
