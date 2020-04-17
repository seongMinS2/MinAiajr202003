package gwajae_object3;

import java.util.Scanner;

public class MainMarble {
    public static void main(String[] args) {

        //객체 생성
        Marble mar = new Marble();
        boolean exit = true;
        
        Scanner sc = new Scanner(System.in);
        while(exit) {
        
        System.out.println("엔터를 입력하세요.");
        sc.nextLine();
        	
        //구슬게임 실행
        int marbles = (int)(Math.random()*10)+1;
        int win = (int)(Math.random()*2)+1;
        System.out.println(win);
        mar.kidsMarbles(win, marbles);
        
        	
        }
    }
}