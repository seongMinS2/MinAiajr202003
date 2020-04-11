package op;

public class ArithOp {

	public static void main(String[] args) {
		// 1.숫자 정수 타입의 두개를 받는다. ->변수 선언
		int a;
		int b;

		a = 10;
		b = 5;

		// 2. 덧셈 연산 -> 결과를 출력하자.

		int c = a + b;
		System.out.println("a + b = " + c);

		// 3. 빼기 연산 - > 결과를 출력하자
		c = a - b;
		System.out.println("a - b = " + c);

		// 4. 곱의 연산 - > 결과 출력
		c = a * b;
		System.out.println("a * b = " + c);

		// 5. 나누기 연산 -> 결과 출력
		c = a / b;
		System.out.println("a / b = " + c);

	}

}
