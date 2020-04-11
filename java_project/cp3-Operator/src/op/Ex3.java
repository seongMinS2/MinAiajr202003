package op;

public class Ex3 {
	
//	3+6, 3+6+9, 3+6+9+12 의 연산을 하는 프로그램 작성.
//	단. 덧셈 연산의 횟수 최소화

	
	public static void main(String[] args) throws Exception{
		
//		int sum = 0;
//		int result = 0;
//		for(int n=2; n<=4; n++) {
//			sum = (3+3*n)*n/2;
//			result += sum;
//		}
//		
//		System.out.println(result);
		
		int sum = 0;
		int result = 0;
		for(int n=3; n<=5; n++) {
			sum = (3-(3*n))*n/2;
			result -= sum;
		}
		System.out.println(result);
	}
}