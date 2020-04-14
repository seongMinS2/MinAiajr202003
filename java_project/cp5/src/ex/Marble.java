package ex;

public class Marble {

    int kidsMarbles1 = 15;
    int kidsMarbles2 = 9;

        public void marbleGame1(int kidsMarbles1,int kidsMarbles2){
            System.out.println("어린이1이 구슬 2개를 획득하였습니다.");
            kidsMarbles1 += 2;
            kidsMarbles2 -= 2;
            System.out.println("보유 구슬" + kidsMarbles1);
            System.out.println("보유 구슬" + kidsMarbles2);
        }

        public void marbleGame2(int kidsMarbles1,int kidsMarbles2){
            System.out.println("어린이2가 구슬 7개를 획득하였습니다.");
            kidsMarbles2 += 7;
            kidsMarbles1 -= 7;
            System.out.println("보유 구슬" + kidsMarbles1);
            System.out.println("보유 구슬" + kidsMarbles2);
        }

}

