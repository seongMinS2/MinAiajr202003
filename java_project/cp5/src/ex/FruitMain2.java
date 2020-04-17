package ex;

public class FruitMain2 {
    public static void main(String[] args) {

        //seller1 객체 생성
        FruitSeller seller1 = new FruitSeller(30, 0, 1000);
        //seller2 객체 생성
        FruitSeller seller2 = new FruitSeller(20, 0 , 1500);
        //seller3 객체 생성
        FruitSeller seller3 = new FruitSeller(20, 0 , 1000);

        // buyer 객체 생성
        FruitBuyer buyer = new FruitBuyer(10000, 0);

        // seller1에게 구매
        buyer.buyApple(seller1, 3000);
        seller1.showSaleResult();

        // seller2에게 구매
        buyer.buyApple(seller2, 3000);
        seller2.showSaleResult();

        // seller3에게 구매
        buyer.buyApple(seller3, 4000);
        seller3.showSaleResult();

    }
}
