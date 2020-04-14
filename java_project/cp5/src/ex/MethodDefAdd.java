package ex;

import org.omg.Messaging.SyncScopeHelper;

import javax.sound.midi.Soundbank;
import java.util.SortedMap;

public class MethodDefAdd {
    public static void main(String[] args) {

        MethodDefAdd md = new MethodDefAdd();

        System.out.println("프로그램의 시작");
        MethodDefAdd.hiEveryone(12, 177.5);
        hiEveryone(13, 125.8);
        hiEveryone(17,183);
        hiEveryone(25,195.1);
        hiEveryone(15,166.9);
        hiEveryone(19, 170);
        System.out.println("프로그램의 끝");
    }

    public static void hiEveryone(int age, double height){
        System.out.println("안녕하세요.");
        System.out.println("제 나이는 " + age + "세입니다.");
        System.out.println("저의 키는" + height + "cm 입니다.");
    }

}
