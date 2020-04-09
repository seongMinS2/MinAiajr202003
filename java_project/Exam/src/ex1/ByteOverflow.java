package ex1;

public class ByteOverflow {

	public static void main(String[] args) {

		byte b = 0; // byte형 변수 b를 선언하고 0으로 초기화
		int i = 0;

		for (int x = 0; x <= 270; x++) {
			System.out.print(b++);
			// print는 출력 후 줄 바꿈을 하지 않는다.
			System.out.print('\t'); // tab을 출력한다.
			System.out.println(i++);
		}
	}

}
