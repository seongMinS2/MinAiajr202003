package gwajae_object2;

public class MainTriangle {
    public static void main(String[] args) {

        //인스턴스 생성
        Triangle t = new Triangle();

        //밑변과 높이 변경 및 확인
        System.out.println("변경전 밑변: " + t.base);
        System.out.println("변경전 높이: " + t.height);
        //변경후
        t.changeValue(30,50);
        System.out.println("변경후 밑변: " + t.base);
        System.out.println("변경후 높이: " + t.height);

        //삼각형의 넓이 계산
        double result = t.TriangleWidth(50,70);

        //출력
        System.out.println(result);
    }

}
