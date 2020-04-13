package selfTest.ex;

public class LoopTest {

	public static void main(String[] args) {
		// 구구단 만들기
		
		//for문 활용
		for(int i=2; i<6; i++) {
			System.out.println(i + "단");
			System.out.println("----------------------------");
			for(int j=1; j<=9; j++) {
				int result = i*j;
				
				System.out.println(i + "x" + j + "=" + result);
			}
			System.out.println("---------------------------");
		}
		
		//while문 활용
		int i = 2;
		
		
		
		while (i < 10) {
			int j = 1;
			System.out.println(i + "단");
			System.out.println("---------------------");
			
			while (j < 10) {
				System.out.println(i + "x" + j + "=" + (j*i));
				j++;
			}
			System.out.println("---------------------");
			i++;

		}
		
//		int i=1;
//		
//		while(i<=100) {
//			System.out.println(i);
//			i++;
//		}
//		
//		i = 1;
//		do {
//			System.out.println(i);
//			i++;
//		}while(i<=50);
		
		
		
		
		
	}
}
