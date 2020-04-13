package selfTest.ex;

public class DoWhileWhileBasic {
	public static void main(String[] args) throws Exception {

		int num = 0;

		do {
			System.out.println("I like you" + num);
			num++;
			 
			Thread.sleep(500);
		} while(num<100);
	}
}
