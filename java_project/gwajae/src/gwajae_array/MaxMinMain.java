package gwajae_array;

public class MaxMinMain {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for(int i = 0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*1000)+1;
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        System.out.println("최대값: " + MaxMin.maxValue(arr));

        System.out.println("최소값: " + MaxMin.miniValue(arr));
    }
}
