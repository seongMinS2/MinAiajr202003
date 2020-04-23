package ver04;

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
        System.out.println("이름:" + this.address);
        System.out.println("전화번호:" + this.email);
        System.out.println("생일:" + this.major);
        System.out.println("생일:" + this.year);
    }

    @Override
    boolean checkName(String name) {
        return super.checkName(name);
    }

}
