package op;

public class ArgEx09 {

	public static void main(String[] args) {
//		1. 작은수(min)~큰수(max)이라 가정을 하고 합을 저장할 변수 sum을 선언한다.
//		2. 반복문(for)를 이용하여 max값 까지 반복을 시킨다.
//		3. 반복을 시킬때 조건(if)을 주어 반복된수(i)에 3을 나눈 나머지 값이 0이 될때 sum에 저장하여 누적시킨다.
//		4. 결과를 출력한다.
		
		
		int min = 0;
		int max = 100;
		int sum = 0;
		
		for(min = 1; min <= max; min++) {
			if(min%3 == 0) {
				sum += min;
			}
		}
		System.out.println(sum);
	}

}
