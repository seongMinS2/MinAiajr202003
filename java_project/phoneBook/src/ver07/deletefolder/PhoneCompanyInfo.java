package ver07.deletefolder;

public class PhoneCompanyInfo extends PhoneInfor {

	private String company;     //회사이름
	private String dept;        //부서이름
	private String job;         //직급


    public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public PhoneCompanyInfo(String name, String phoneNumber, String addr, String email, String company, String dept, String job) {
        super(name, phoneNumber, addr, email);
        this.company = company;
        this.dept = dept;
        this.job = job;
    }

    @Override
    public void showAllInfo() {
        super.showAllInfo();
        System.out.println("회사이름: " + this.company);
        System.out.println("부서이름: " + this.dept);
        System.out.println("직급: " + this.job);
    }
}
