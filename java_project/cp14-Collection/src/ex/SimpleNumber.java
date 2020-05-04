package ex;

public class SimpleNumber {

    int num;

    public SimpleNumber(int num) {
        this.num = num;
    }

    @Override
    public String toString() {

        return String.valueOf(num);
    }

    // HashSet의 동등 비교 과정
    //1. hash 코드를 비교 같은 Hash 코드를 가진 객체를 기반으로 비교
    //2. equals 메서드로 비교

    @Override
    public int hashCode() {
        return this.num%3;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        //num 의 값을 비교

        if (obj instanceof SimpleNumber) {
            SimpleNumber sm = (SimpleNumber) obj;
            result = this.num == sm.num;
        }
        return result;
    }
}
