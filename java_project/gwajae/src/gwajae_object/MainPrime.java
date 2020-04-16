package gwajae_object;

public class MainPrime {
    public static void main(String[] args) {


        for(int i=0; i<=100; i++){
            if(PrimeNumber.isPrime(i)){
                System.out.println("1~100까지 소수값: " + i);
            }
        }
    }
}
