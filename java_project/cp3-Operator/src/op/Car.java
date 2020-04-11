package op;

public class Car {
	static int num = 1;
	public int num2 = 1;
	
	private int currentSpeed;

	private int accelerationTime;

	public void accelerate(int speed, int second) {

		System.out.println(second + "초간 속도를 시속 " + speed + "(으)로 가속함!!");

	}
}
