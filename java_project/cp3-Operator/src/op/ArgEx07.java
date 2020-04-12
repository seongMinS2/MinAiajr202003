package op;

public class ArgEx07 {

	public static void main(String[] args) {
//		1. 두변수의값을 num1, num2로 받는다.
//		2. 임시로 변수를 담아둘 num3을 선언하여 num1값을 저장해 둔다.
//		3. num2값을 num1값으로 저장한다.
//		4. num3에 담아둔 num1의값을 num2로 저장한다.
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 0;
		
		num3 = num1;
		num1 = num2;
		num2 = num3;
		System.out.println(num1 + ", " + num2);
		

	}

}
