package ver01;

public class PhoneInfor {

    // private : 변수의 직접 참조를 막는다, 정보은닉
    private String name;            //이름
    private String phoneNumber;     //전화번호
    private String birthday;        //생년월일

    PhoneInfor(String name, String phoneNumber, String birthday){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    PhoneInfor(String name, String phoneNumber){
        this(name, phoneNumber, "입력값이 없습니다.");
    }

    void showInfo(){
        System.out.println("이름:" + this.name);
        System.out.println("전화번호:" + this.phoneNumber);
        System.out.println("생일:" + this.birthday);
//        if(this.birthday == null){
//            System.out.println("생일: 입력값이 없습니다.");
//
//        } else {
//            System.out.println("생일:" + this.birthday);
//        }
    }
}
