package ver04.v3;

public class PhoneUnivInfo extends PhoneInfor {

    String major;
    String grade;

    public PhoneUnivInfo(String name, String phoneNumber, String addr, String email, String major, String grade) {
        super(name, phoneNumber, addr, email);
        this.major = major;
        this.grade = grade;
    }

    @Override
    void showAllInfo() {
        super.showAllInfo();
        System.out.println("전공: " + this.major);
        System.out.println("학년: " + this.grade);
    }
}
