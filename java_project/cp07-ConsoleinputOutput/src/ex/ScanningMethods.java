package ex;

import java.util.Scanner;

public class ScanningMethods {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("당신의 이름은? ");
        String  str = keyboard.nextLine();
        System.out.println("안녕하세요" + str + '남');

    }
}
