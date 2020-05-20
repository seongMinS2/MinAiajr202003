package selfTest.ex;

public class ObjectTest {

	public static void main(String args[]) {
	
		Parent ag1 = new Child();
		//부모의 age값으로 초기화 되는걸 발견
		//자식만 있는 변수는 없어짐
		System.out.println(ag1.age);
		
		Child ag2 = new Child();
		//자식의 age값으로 초기화 되는걸 발견
		System.out.println(ag2.age);
		
		//당연히 안됨
		//Child ag3 = new Parent();
		
		//문법상 맞다고 착각하고 넘어가나 프로그램 실행시
		//new Parent() 인스턴스는 Child형 데이터로 바꿀수 없다는걸
		//인지하고 런타임 오류를 발생시킴
		Child ag4 = (Child) new Parent();
		
		//업캐스팅한 객체는 예외적으로 다운캐스팅 가능
		//부모의 age값을 갖고 있는걸 발견
		//자식타입으로 변환되며 자식만 갖고있는 변수가 다시 생성된걸
		//볼 수 있음
		Child ag5 = (Child)ag1;
		System.out.println(ag5.age);
		System.out.println(ag5.phoneNum);
 }
}
