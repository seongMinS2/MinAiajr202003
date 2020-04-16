package gwajae_object;

public class PrimeNumber {


    public static boolean isPrime(int num) {
        boolean result = true;
        for(int i = 2; i < num; i++) {
            if( num%i == 0) {
                result = false;
                break;
                //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
            } else {
                result = true;
            }
        }
        return result;
    }
}
