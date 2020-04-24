package scm;

public class Product {

    int price; // 제품의 가격
    int bonusPoint; //제품의 포인트

    public Product(int price) {
        this.price = price;
        this.bonusPoint = this.price / 10;
    }

}


