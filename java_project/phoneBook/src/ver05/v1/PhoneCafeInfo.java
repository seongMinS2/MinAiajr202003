package ver05.v1;

public class PhoneCafeInfo  extends PhoneInfor implements Info {

    String cafeName;    //동호회 이름
    String nicName;     //닉네임

    public PhoneCafeInfo(String name, String phoneNumber, String addr, String email, String cafeName, String nicName) {
        super(name, phoneNumber, addr, email);
        this.cafeName = cafeName;
        this.nicName = nicName;
    }

    @Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.println("동호회 이름: " + this.cafeName);
        System.out.println("닉네임: " + this.nicName);
    }
}
