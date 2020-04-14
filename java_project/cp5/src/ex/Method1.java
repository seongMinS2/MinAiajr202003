package ex;

public class Method1 {

	public static void main(String args[]) {

		MyMath math = new MyMath();

		long result = math.add(10, 100);

		System.out.println(result);

	}

	int add() {
		return 10;
	}
}
