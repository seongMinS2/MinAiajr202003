package ver04.v3;

public class PhoneCompanyInfo extends PhoneInfor {

    String company;     //회사이름
    String dept;        //부서이름
    String job;         //직급


    public PhoneCompanyInfo(String name, String phoneNumber, String addr, String email, String company, String dept, String job) {
        super(name, phoneNumber, addr, email);
        this.company = company;
        this.dept = dept;
        this.job = job;
    }

    @Override
    void showAllInfo() {
        super.showAllInfo();
        System.out.println("회사이름: " + this.company);
        System.out.println("부서이름: " + this.dept);
        System.out.println("직급: " + this.job);
    }
}
