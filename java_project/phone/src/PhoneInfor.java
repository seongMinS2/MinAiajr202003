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
}
