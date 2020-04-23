package gwajae_array;

public class MaxMin {


    //최대값 반환
    public static int miniValue(int[] arr){
        int result = arr[0];
        for(int i=0; i<arr.length; i++){
            if(result < arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }


    //최소값 반환
    public static int maxValue(int[] arr){
        int result = arr[0];
        for(int i=0; i<arr.length; i++){
            if(result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }
}

