package ver04.v2;

public class PhoneUnivlnfor extends PhoneInfor {

    private String address;
    private String email;
    private String major;
    private String year;

    public PhoneUnivlnfor(String name, String phoneNumber, String birthday, String address, String email, String major, String year) {
        super(name, phoneNumber, birthday);
        this.address = address;
        this.email = email;
        this.major = major;
        this.year = year;
    }

    public PhoneUnivlnfor(String name, String phoneNumber, String address, String email, String major, String year) {
        super(name, phoneNumber);
        this.address = address;
        this.email = email;
        this.major = major;
        this.year = year;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("주소:" + this.address);
        System.out.println("이메일:" + this.email);
        System.out.println("전공:" + this.major);
        System.out.println("학년:" + this.year);
    }

    @Override
    boolean checkName(String name) {
        return super.checkName(name);
    }

}
