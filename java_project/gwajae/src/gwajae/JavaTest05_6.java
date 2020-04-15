package gwajae;

public class JavaTest05_6 {
    public static void main(String[] args) {
//        [6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을작성하시오.

        int dice1 = (int)(Math.random()*6)+1;
        int dice2 = (int)(Math.random()*6)+1;
        System.out.println(dice1 + "," + dice2);
        if((dice1 + dice2) == 6){
            System.out.println("주사위의 합이 6입니다.");
        }
    }
}
