package selfTest.ex;

public class Child extends Parent{

	//부모에도 있는 변수
	int age;
	
	//자식에만 있는 변수
	String addr;
	String phoneNum;
	
	public Child() {
		//부모,자식 같은 age변수를 초기화시킴
		super.age = 3;
		this.age = 5;
		
	}
}
