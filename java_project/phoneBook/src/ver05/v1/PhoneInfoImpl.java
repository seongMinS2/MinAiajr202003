package ver05.v1;

public abstract class PhoneInfoImpl  {
    // private : 변수의 직접 참조를 막는다, 정보은닉
    String name;            //이름
    String phoneNumber;     //전화번호
    String addr;           //주소
    String email;          //이메일

    public PhoneInfoImpl(String name, String phoneNumber, String addr, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addr = addr;
        this.email = email;
    }
}
