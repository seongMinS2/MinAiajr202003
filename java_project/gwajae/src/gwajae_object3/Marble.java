package gwajae_object3;

public class Marble {
    int kids1 = 100; //구슬 개수
    int kids2 = 100; //구슬 개수
    int count = 0;

    //구슬게임
    void kidsMarbles(int n1, int n2){
        if(n1 == 1){
            kids1 += n2;
            kids2 -= n2;
            count ++;
            System.out.println(count + "차 게임에서 어린이 1은 어린이2의 구슬 " + n2 + "개를 획득한다");
            System.out.println("어린이1의 남은 구슬 개수: "+kids1);
            System.out.println("어린이2의 남은 구슬 개수: "+kids2);
        }else if(n1 == 2){
            kids1 -= n2;
            kids2 += n2;
            count ++;
            System.out.println(count + "차 게임에서 어린이 2은 어린이1의 구슬 " + n2 + "개를 획득한다");
            System.out.println("어린이1의 남은 구슬 개수: "+kids1);
            System.out.println("어린이2의 남은 구슬 개수: "+kids2);
        }
    }
}
