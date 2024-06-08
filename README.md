# JAVA

1) scanner_원넓이구하기
2) random_number : 0-99 random number
3) gameplay
  : 가위,바위,보 게임
  [철수와 영희가 가위바위보 게임을 수행하는 GamePlay 클래스를 생성하기]
  먼저 철수 의 이름을 출력하고 가위 ”, 바위 ”, 보 중 하나를 문자열로 입력 받고, 영희 에 대해서도 동일한 방법으로 입력받는다.
  입력 받은 문자열을 판별하여 승자를 출력하는 프로그램을 작성한다.
    - 문자열을 읽기 위해서는 Scanner 클래스의 next() 메소드를 이용
    - 문자열 비교는 == 연산자를 사용하지 않고 다음과 같이 한다
      String myChoice
      if (myChoice. equals 가위 ”))
4) StudyCafeUI : 프로젝트 직렬화하여 화일 입출력을 행하고 처리하는 프로그램으로 발전시키기
    - 피드백)
      - ObjectOutputStream 화일객체의 선언은 UI 클래스에서 선언
        -> 그 화일 객체를 Management 클래스에 파라메터로 옮겨 주어야 화일 이름과 무관한(독립적인) Management 클래스를 만들 수 있다.
      - 이전의 DataOutputStream 화일객체의 선언도 마찬가지로 UI 클래스에서 선언해 주어야 한다.
5) CheckingAccount
   : CheckingAccount 클래스를 이용한 UI 인터페이스 만들기
    - 처음 실행하면 해당 번호 누르기 - 1. 저금 2. 인출 3. 카드 지불 4. 종료
    - 조건)
      - 1,2,3  모두 잔고는 항상 사용자가 알 수 있게 표시
      - 1,2,3,4 이외의 숫자 또는 문자 등등 입력이 잘못되면 "잘못 누르셨습니다" 메시지와 함께 다시 처음으로 이동(어떤 익셉션이 발생될 것인가를 살펴보고 try - catch 문으로 해결할 것)
      - 만약 인출, 카드 지불시 잔고가 모자란 경우에는 적절한 메시지을 내 보내주고, 다시 처음으로 실행
      - 가능하면, Account, CheckingAccount 클래스의 모든 데이터 멤버에는 private 키워드를 붙이고, 필요하면 get, set 접근자 설정자 함수를 추가할 것
