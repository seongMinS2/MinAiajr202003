package gwajae_array;

public class AddArrayMain {
    public static void main(String[] args) {
        int[][] arr = new int[5][7];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++) {
                int num = (int)(Math.random()*300) + 1;
                arr[i][j] =num;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        AddArray.addOneDArr(arr, 5);
    }
}
