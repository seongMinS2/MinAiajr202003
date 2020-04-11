package op;

import java.util.Arrays;

public class Test2 {
	public static void main(String args[]) {
		int[] arr1 = new int[]{1, 2, 3, 4, 5};

		int newLen = 10;

		// 1. System 클래스의 arraycopy() 메소드
		
		

		int[] arr2 = new int[newLen];
		
		

		System.arraycopy(arr1, 0, arr2, 0, 3);

		for(int i=0; i< arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}

		
		
		// 2. Arrays 클래스의 copyOf() 메소드

		int[] arr3 = Arrays.copyOf(arr1, 10);
		 

		
		// 3. Object 클래스의 clone() 메소드

		int[] arr4 = (int[])arr1.clone();
		 

		// 4. for 문과 인덱스를 이용한 복사

		int[] arr5 = new int[newLen];
		
	


	}
}
