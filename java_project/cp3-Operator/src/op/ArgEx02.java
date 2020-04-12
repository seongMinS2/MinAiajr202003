package op;

public class ArgEx02 {

	public static void main(String[] args) {
//		1- 두 숫자를 받는다.
//		2- 조건문을 이용하여 두 값이 음수이거나 양수이면 -를 두값이 다른 수 이면 음수를 
//		    양수로 변환하여 +를 해준다.
//		   (ex -10, +10 = 20        /        +10, +15 = 5              / -10,   -15 = 5 ) 
//		3- 값을 출력 한다.
		
		int num1 = -3;
		int num2 = 10;
		
		//Math.abs -> 숫자를 절대값으로 표현해주는 메소드
		//두 값이 음수 일때
		if(num1 < 0 && num2 < 0) {
			System.out.println(Math.abs(num1 - num2));
		}
		//두 수가 서로 다른 수(음수,양수)일때
		else if (num1 < 0 || num2 < 0) {
			System.out.println(Math.abs(num1 + num2));
		}
		//두 값이 양수 일때
		else if (num1 > 0 && num2 > 0) {
			System.out.println(Math.abs(num1 - num2));
		}

	}

}
