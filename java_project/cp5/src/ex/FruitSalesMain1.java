package ex;

public class FruitSalesMain1 {
    public static void main(String[] args) {

        //샐러 생성 : 인스턴스화
        FruitSeller seller = new FruitSeller();
        FruitSeller seller2 = new FruitSeller();
        //바이어 생성 : 인스턴스화
        FruitBuyer buyer = new FruitBuyer();

        //바이어 구매
        buyer.buyApple(seller, 2000);

        System.out.println("과일 판매자의 현재 상황");
        seller.showSaleResult();

        System.out.println("과일 구매자의 현재 상황");
        buyer.showBuyResult();


    }
}
