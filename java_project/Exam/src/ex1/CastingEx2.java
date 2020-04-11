package ex1;

public class CastingEx2 {
	
	public static void main(String args[]) {
	
//	byte b= 10;
//	int i =(int)b;
//	System.out.println("i=" + i);
//	System.out.println("b=" + b);
//
//	int i2 = 300;
//	byte b2 = (byte)i2;
//	System.out.println("i2=" + i2);
//	System.out.println("b2=" + b2);

		int[] grade = new int[]{85, 65, 90}; // 길이가 3인 int형 배열을 선언과 동시에 초기화

		int sum = 0;
		int j = 0;
		
		for(int i:grade) {
			j += i;
			System.out.println(i);
			
		}
		System.out.println();
		System.out.println(j / grade.length);

		for (int i = 0; i < grade.length; i++) {

		    sum += grade[i];

		}

		System.out.println("모든 과목에서 받은 점수의 합은 " + sum + "입니다.");

		System.out.println("이 학생의 평균은 " + (sum / grade.length) + "입니다.");
	}
}
