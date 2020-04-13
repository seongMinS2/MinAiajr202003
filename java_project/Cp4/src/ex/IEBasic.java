package ex;

public class IEBasic {

	public static void main(String[] args) {
		if(true) {
			System.out.println("true 일때 출력");
		}
		
		if(false) {
			System.out.println("true 일때 출력");
		} else {
			System.out.println("false 일때 출력");
		}
		
		if(10>5) {
			System.out.println("10은 5보다 큽니다.");
		}
		
		int num = 10;
		
		if(num==5) {
			System.out.println("10은 5와 같습니다.");
		}
		
		
		//양수 판별 : 양수 일때 " 양수 입니다."
		
		if(num>0) {
			System.out.println("양수입니다.");
		}
		
		// 홀/짝수 판별 : num%2==0 -> 짝수, num%2==1 ->홀수
		if(num%2==0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}
		
	}

}
