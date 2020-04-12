package op;

public class ArgEx05 {
	
	

	public static void main(String[] args) {
//		1. 세 숫자를 받는다.
//		2. 임의의 두 숫자를 비교 한다.
//		3. 둘 중 큰 숫자와 나머지 숫자를 비교한다. ( x > y) -> z와 비교
//		4. 결과(제일 큰수) 를 출력한다.
		int num1 = 3;
		int num2 = 21;
		int num3 = 9;
		
		if(num1 > num2)
			if(num3<num1) 
				System.out.println(num1);
			else 
				System.out.println(num3);
			
		else
			if(num3<num2)
				System.out.println(num2);
			else
				System.out.println(num3);
			
		

//		---------------------------------------------------------
//
//		1. 세 숫자를 받는다.
//		2. a 변수에 저장한 후 다른 숫자와 비교를 한다.
//		3. 큰 숫자를 a변수에 저장한다.
//		4. 비교 후 출력한다.
		
		
	}

}
