import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectSerializable2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 객체 저장
        FileInputStream fi = new FileInputStream("Object.ser");
        // 파일에서 데이터를 추출 -> 객체 역직렬화 필터 스트림
        ObjectInputStream in = new ObjectInputStream(fi);

        Circle c1 = (Circle) in.readObject();
        Circle c2 = (Circle) in.readObject();
        String string = (String) in.readObject();

        c1.showCircleInfo();
        c2.showCircleInfo();
        System.out.println(string);
    }
}
