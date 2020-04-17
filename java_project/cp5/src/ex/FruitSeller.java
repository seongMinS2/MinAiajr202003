package ex;
/*
작성자 : 박성민
수정일 : 2020.04.17
수정 내용 : 생성자로 변수 초기화, 현재 데이터 출력 메서드 생성 (showResult())
*/

public class FruitSeller {

    //사과의 가격
    //맴버 변수, 인스턴스 변수
    // 수정 : 변수의 명시적 초기화 변경

    int numOfApple; //사과의 갯수
    int myMoney;    //보유한 돈
    final int APPLE_PRICE;   //사과의 가격

    // 생성자

    FruitSeller(){
//        numOfApple = 20;
//        myMoney = 0;
//        APPLE_PRICE = 20;
        this(20, 0, 1000);
    }

    FruitSeller(int num){
        this(num, 0, 1000);
    }


    FruitSeller(int numOfApple, int myMoney, int APPLE_PRICE){
        this.numOfApple = numOfApple;
        this.myMoney = myMoney;
        this.APPLE_PRICE = APPLE_PRICE;
    }

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