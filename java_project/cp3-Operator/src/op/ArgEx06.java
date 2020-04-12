package op;

import java.util.Scanner;

public class ArgEx06 {

	public static void main(String[] args) {
//		1. 임의의 숫자들을 받는다.
//		2. 숫자를 두개 씩 서로 비교하여 큰 숫자를 추출 한다.
//		3. 마지막에 남는 숫자가 제일 큰 최대값이다.
//		4. 출력한다.
		
		
		int num1 = 0;
		int maxNum = 0;

		Scanner sc = new Scanner(System.in);
		for(int i=0; i<=5; i++) {
			System.out.println("값을 입력 하시오.");
			
			num1 = sc.nextInt();
			if(maxNum < num1) {
				maxNum = num1;
			}
			System.out.println("최대값은 -> " + maxNum);
		}
		
	}

}
