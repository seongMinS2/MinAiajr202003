package ex;

import java.util.Scanner;

public class ExceptionEx {
    public static void main(String[] args) {


        System.out.println("나이를 입력해주세요.");
        try {
            int age = readAge();
            //Exception e = new Exception("고의로 발생 시킴");
            System.out.println("나이는 " + age + "세 입니다.");
        } catch (AgeInputException e) {
            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println("에러 메세지: " + e.getMessage());
//            e.printStackTrace();
//        }

        }
    }

    static int readAge() throws AgeInputException {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age < 0) {

            AgeInputException e = new AgeInputException();
            //Exception e = new Exception("고의로 발생 시킴");
        }
        return age;
    }


}
