package gwajae;

public class JavaTest04_16 {
    public static void main(String[] args) {
//        1 부터 99까지의 합을 구하는 프로그램 작성
//        while문, for문, do while 문을 각각 사용
//        int sum = 0;

//        for(int i=1; i<100; i++){
//            sum +=i;
//        }
//        System.out.println("1~99까지의 합: " + sum);

//        int sum = 0;
//        int i=0;
//        while(i<100){
//            sum+=i;
//            i++;
//        }
//        System.out.println("1~99까지의 합: " + sum);

        int sum = 0;
        int i = 0;
        do{
            sum+=i;
            i++;
        }while(i<100);
        System.out.println("1~99까지의 합: " + sum);

    }
}
