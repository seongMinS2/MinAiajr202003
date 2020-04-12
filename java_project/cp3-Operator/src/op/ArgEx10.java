package op;

public class ArgEx10 {

	public static void main(String[] args) {
//		1. 작은수(min)~큰수(max)이라 가정을 하고 결과값을 저장할 변수 result와 양수의합(sum1) 음수의합(sum2)를 선언한다.
//		2. 반복문(for)를 이용하여 100까지 반복을 시킨다.
//		3. 반복을 시킬때 조건(if)을 주어 i를 2로나눈 나머지가 0일때 음수의합(sum2)에 누적시킨다.
//		4. 반대로 0이 아닐때 양수의합(sum1)에 누적시킨다.
//		5. 두 합을 더하여 나온 값을 result값으로 출력한다.

		
		int result = 0;
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i<=100; i++) {
			if(i%2 == 0) {
				sum2 -= i;
			} else {
				sum1 += i;
			}
		}
		result = sum1+sum2;
		System.out.println(result);
	}

}
