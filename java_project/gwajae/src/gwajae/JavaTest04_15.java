package gwajae;

import java.util.Random;

public class JavaTest04_15 {
    public static void main(String[] args) {


//        int n = (int)(Math.random()* 5)+1;
//        System.out.println(n);
//        switch (n) {
//            case 1:
//                System.out.println("현재 인원은 1명 입니다.");
//                break;
//            case 2:
//                System.out.println("현재 인원은 2명 입니다.");
//                break;
//            case 3:
//                System.out.println("현재 인원은 3명 입니다.");
//                break;
//            default:
//                System.out.println("현재 많은 사람들이 있습니다.");
//                break;
//        }
//        n=1 일 때  “현재 인원은 1명 입니다.”
//        n=2 일 때  “현재 인원은 2명 입니다.”
//        n=3 일 때  “현재 인원은 3명 입니다.”
//        n>3 일 때  “현재 많은 사람들이 있습니다.”
//        위의 내용이 출력 되는 프로그램을 작성. 각각 If 문과 switch 문 사용

        int n = (int)(Math.random()* 5)+1;
        if(n==1)
             System.out.println("현재 인원은 1명 입니다.");
        else if(n==2)
        System.out.println("현재 인원은 2명 입니다.");
        else if(n==3)
             System.out.println("현재 인원은 3명 입니다.");
        else
             System.out.println("현재 많은 사람들이 있습니다.");


    }
}
