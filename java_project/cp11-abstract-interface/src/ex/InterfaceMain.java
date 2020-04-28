package ex;

import java.util.Scanner;

public class InterfaceMain {
    public static void main(String[] args) {
        System.out.println("요일을 선택해주세요.");
        System.out.println("1.월, 2.화, 3.수, 4.목, 5.금, 6.토, 7.일");

        Scanner sc = new Scanner(System.in);

        switch(sc.nextInt()){
            case Week.MON:
                System.out.println("월요일입니다.");
            case Week.TUE:
                System.out.println("화요일입니다.");
            case Week.WED:
                System.out.println("수요일입니다.");
            case Week.THU:
                System.out.println("목요일입니다.");
            case Week.FRI:
                System.out.println("금요일입니다.");
            case Week.SAT:
                System.out.println("토요일입니다.");
            case Week.SUN:
                System.out.println("일요일입니다.");

        }
    }
}
