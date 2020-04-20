public class PhoneInfor {


    String name;            //이름
    String phoneNumber;     //전화번호
    String birthday;        //생년월일


    //생성자 오버로딩
    //생년월일은 선택적으로 저장 가능
    PhoneInfor(String name,String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    PhoneInfor(String name,String phoneNumber,String birthday){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    PhoneInfor(){}

    //객체의 정보를 읽기 위해 toString메서드 재정의
    @Override
    public String toString() {
        return "고객정보{" +
                "이름='" + name + '\'' +
                ", 전화번호='" + phoneNumber + '\'' +
                ", 생일='" + birthday + '\'' +
                '}';
    }
}
