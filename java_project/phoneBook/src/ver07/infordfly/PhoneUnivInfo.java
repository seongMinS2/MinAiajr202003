package ver07.infordfly;

public class PhoneUnivInfo extends PhoneInfor implements Info {

	private String major;
	private String grade;

    public PhoneUnivInfo(String name, String phoneNumber, String addr, String email, String major, String grade) {
        super(name, phoneNumber, addr, email);
        this.major = major;
        this.grade = grade;
    }

    public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.println("전공: " + this.major);
        System.out.println("학년: " + this.grade);
    }
}
