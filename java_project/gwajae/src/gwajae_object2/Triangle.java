package gwajae_object2;

public class Triangle {

    //밑변과 높이 정의
    int base = 0;
    int height = 0;

    //밑변과 높이 값 변경 메소드
    void changeValue(int b, int h){
        this.base = b;
        this.height = h;
    }

    //삼각형 넓이 반환메서드
    double TriangleWidth(int b, int h){
        return (b*h) / 2;
    }
}
