package ver07.dto;

import java.sql.Date;

public class CompanyDTO {
	private int idx1;
	private String name;            //이름
	private String phoneNumber;     //전화번호
	private String addr;           //주소
	private String email;          //이메일
	private Date regdate;
	private int idx3;
	private String company;
	private int ref2;
	
	public CompanyDTO() {}
	
	
	
	public CompanyDTO(String name, String phoneNumber, String addr, String email, String company) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
		this.company = company;
	}



	public CompanyDTO(int idx1, String name, String phoneNumber, String addr, String email, Date regdate, int idx3,
			String company, int ref2) {
		this.idx1 = idx1;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
		this.regdate = regdate;
		this.idx3 = idx3;
		this.company = company;
		this.ref2 = ref2;
	}


	public int getIdx1() {
		return idx1;
	}


	public void setIdx1(int idx1) {
		this.idx1 = idx1;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getIdx3() {
		return idx3;
	}


	public void setIdx3(int idx3) {
		this.idx3 = idx3;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public int getRef2() {
		return ref2;
	}


	public void setRef2(int ref2) {
		this.ref2 = ref2;
	}
	
	

}
