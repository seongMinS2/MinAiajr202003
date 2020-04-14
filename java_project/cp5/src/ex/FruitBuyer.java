package ex;

public class FruitBuyer {
    int myMoney=5000;   //구매자 보유 머니
    int numOfApple=0;   //구매자 보유 사과

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
