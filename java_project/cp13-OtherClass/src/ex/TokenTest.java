package ex;

import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String phoneNumber = "Tel 82-02-997-2059 test";

        StringTokenizer st1 = new StringTokenizer(phoneNumber);


        //while (st1.hasMoreTokens()) {
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
//            System.out.println(st1.nextToken());
        //}
        StringTokenizer st2 = new StringTokenizer(phoneNumber, "-",true);
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());

    }
}
