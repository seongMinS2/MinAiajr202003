package ver04.v2;

public class PhoneCompaanyInfor extends PhoneInfor {

    private String address;
    private String email;
    private String company;

    public PhoneCompaanyInfor(String name, String phoneNumber, String birthday, String address, String email, String company) {
        super(name, phoneNumber, birthday);
        this.address = address;
        this.email = email;
        this.company = company;
    }

    public PhoneCompaanyInfor(String name, String phoneNumber, String address, String email, String company) {
        super(name, phoneNumber);
        this.address = address;
        this.email = email;
        this.company = company;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("주소: " + this.address);
        System.out.println("이메일: " + this.email);
        System.out.println("회사: " + this.company);
    }

    @Override
    boolean checkName(String name) {
        return super.checkName(name);
    }
}
