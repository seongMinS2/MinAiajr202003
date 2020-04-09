package ex1;

public class CastingOperation {

	public static void main(String[] args) {

		char ch1 = 'A'; // 문자타입의 변수 ch1 선언
		char ch2 = 'Z'; // 문자타입의 변수 ch2 선언

		int num1 = ch1; // ch1 char -> int
		int num2 = (int) ch2; // ch2 char -> int

		System.out.println("문자A의 유니코드 값: " + num1);
		System.out.println("문자Z의 유니코드 값: " + num2);
	}

}
