package op;

public class ArgEx08 {

	public static void main(String[] args) {
//		1. 작은수(min)~큰수(max)이라 가정을 하고 합을 저장할 변수 sum을 선언한다.
//		2. 반복문(for)를 사용하여 i가 max가 될 때까지 반복 시키고 1번 반복할때 마다 sum에 i값을 더해준다.
//		3. 결과를 출력한다.
		
		
		int min = 1;
		int max = 4;
		int sum = 0;
		
		for(min=1; min <=max; min++) {
			sum += min;
		}
		System.out.println(sum);
	}

}
