package ver04.v3;

public class PhoneInfor {

    // private : 변수의 직접 참조를 막는다, 정보은닉
     String name;            //이름
     String phoneNumber;     //전화번호
     String birthday;        //생년월일
     String addr;
     String email;

    PhoneInfor(String name, String phoneNumber, String birthday){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public PhoneInfor(String name, String phoneNumber, String addr, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addr = addr;
        this.email = email;
    }

    PhoneInfor(String name, String phoneNumber){
        this(name, phoneNumber, "입력값이 없습니다.");
    }

    void showInfo(){
        System.out.println("이름:" + this.name);
        System.out.println("전화번호:" + this.phoneNumber);
        System.out.println("생일:" + this.birthday);
    }
    void showAllInfo(){
        System.out.println("이름:" + this.name);
        System.out.println("전화번호:" + this.phoneNumber);
        System.out.println("주소: " + this.addr);
        System.out.println("이메일: " + this.email);
    }

    //name 속성값과 전달받은 문자열을 비교해서 반환
    boolean checkName(String name){
        return this.name.equals(name);
    }
}
