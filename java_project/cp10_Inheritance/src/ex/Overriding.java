package ex;

public class Overriding {
    public static void main(String[] args) {

        BaseEnSpeaker ref1 = new BaseEnSpeaker();

        // 다형성 : 상위클래스 타입의 참조변수에 하위클래스의 인스턴스를 참조
        Speaker sp = new BaseEnSpeaker();
        // 참조변수 sp는 BaseEnSpeaker 인스턴스의 멤버중 Speaker가 가지던 멤버만
        //사용한다.

        sp.showCurrentState();

        //sp.setBaseRate(100);

        ref1.setVolume(10);
        ref1.setBaseRate(20);

        ref1.showCurrentState();



    }
}
