package ex;

public class FruitBuyer {

    //변수의 명시적 초기화 변경
    int myMoney;   //구매자 보유 머니
    int numOfApple;   //구매자 보유 사과

    //생성자
    FruitBuyer(){
        myMoney = 5000;
        numOfApple = 0;
    }

    FruitBuyer(int money, int num){
        myMoney = money;
        numOfApple = num;
    }

    //구매 메소드
    public void buyApple(FruitSeller seller, int money)
    {
        numOfApple+=seller.saleApple(money);
        myMoney-=money;
    }

    //보유 현황
    public void showBuyResult() {
        System.out.println("현재 잔액: " + myMoney);
        System.out.println("사과 개수: " + numOfApple);
    }
}
