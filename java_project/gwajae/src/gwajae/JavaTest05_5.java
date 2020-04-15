package gwajae;

public class JavaTest05_5 {
    public static void main(String[] args) {
//        for(int i=0; i<=10; i++) {
//            for(int j=0; j<=i; j++)
//                System.out.print("*");
//            System.out.println();
//        }
        int i = 0;
        int j = 0;
        while(i <= 10){
            j = 0;
            while(j <= i ){
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
