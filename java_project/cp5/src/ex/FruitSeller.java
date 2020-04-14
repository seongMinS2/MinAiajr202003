package ex;

public class FruitSeller {
    int numOfApple = 20; //사과의 갯수
    int myMoney = 0;    //보유한 돈
    final int APPLE_PRICE = 1000;   //사과의 가격

    //판매 메소드
    public int saleApple(int money) {
        int num = money / APPLE_PRICE;
        numOfApple -= num;
        myMoney += money;
        return num;
    }

    //보유 현황
    public void showSaleResult() {
        System.out.println("남은 사과: " + numOfApple);
        System.out.println("판매 수익: " + myMoney);

    }
}