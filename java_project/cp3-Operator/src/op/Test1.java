package op;

public class Test1 {
	public static void main(String args[]) {
		
		int k=10;
		
		int[][] arr = new int[3][];

		arr[0] = new int[2];

		arr[1] = new int[4];

		arr[2] = new int[11];
		
		
		for(int i=0; i<arr.length; i++) {
				System.out.println();
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = k;
				System.out.print(arr[i][j] + " ");
				k += 10;
				System.out.print(arr[i].length + "  ");
				
			}
		}
	}
}
