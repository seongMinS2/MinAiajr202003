package op;

public class ArgEx01 {

	public static void main(String[] args) {

//1- 두 숫자를 받는다. 혹은 두 숫자를 저장한다.
//2- 두숫자의 크기를 비교한다.
//3- 비교 후 큰수를 알아낸 후 큰수 - 작은수를 한다.


		int num1 = 1;
		int num2 = 2;	
		
		//큰값을 먼저 빼는 조건식
		if(num1>num2) {
			System.out.println("결과: " + (num1 - num2));
		} else {
			System.out.println("결과: " + (num2 - num1));
		}
		

	}

}
