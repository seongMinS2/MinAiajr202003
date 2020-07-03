
public class ArrayIsObject {

	public static void main(String[] args) {
		String[] 배열 = {"객체","입니다","왜냐", "배열을", "콘솔에다","찍으면","뭐가보입니까?"};
		int[] 물론기본자료형도 = {1,2,3,4,5};
		String str = new String[]{"1","2","3","4","5"};
		Object str2 = new String[] {"1","2","3","4","5"};
		System.out.println(물론기본자료형도);
		System.out.println(배열);
		
	}

}
