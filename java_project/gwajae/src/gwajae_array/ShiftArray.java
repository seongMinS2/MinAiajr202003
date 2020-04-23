package gwajae_array;

public class ShiftArray {


    static void shiftArray(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                int[] temp = new int[arr[j].length-1];
                arr[0][j] += 9;
                arr[i][j] -= 3;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
