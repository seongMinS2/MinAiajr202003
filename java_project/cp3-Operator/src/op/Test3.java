package op;

public class Test3 {
	public static void main(String args[]) {
		int[] arr1 = new int[] { 1, 2, 3, 4, 5 };

		int[] arr2 = new int[] { 1, 2, 3, 4, 5 };

		for (int i = 0; i < arr1.length; i++) {

			arr1[i] += 10; // 각 배열 요소에 10을 더함.
			System.out.print(arr1[i] + " ");
		}
			System.out.println();
		for (int e : arr2) {

			e += 10; // 각 배열 요소에 10을 더함.
			System.out.print(e + " ");
		}
		
		System.out.println();
		
		for (int e : arr2) {
			System.out.print(e + " ");
		}
	}
}