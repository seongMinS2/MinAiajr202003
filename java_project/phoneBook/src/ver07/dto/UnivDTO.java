package ver07.dto;

import java.sql.Date;

public class UnivDTO {
	private int idx1;
	private String name; // 이름
	private String phoneNumber; // 전화번호
	private String addr; // 주소
	private String email; // 이메일
	private Date regdate;
	private int idx2;
	private String major;
	private int year;
	private int ref1;

	public UnivDTO() {
	}

	public UnivDTO(String name, String phoneNumber, String addr, String email, String major, int year) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
		this.major = major;
		this.year = year;
	}

	public UnivDTO(int idx1, String name, String phoneNumber, String addr, String email, Date regdate, int idx2,
			String major, int year, int ref1) {
		this.idx1 = idx1;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
		this.regdate = regdate;
		this.idx2 = idx2;
		this.major = major;
		this.year = year;
		this.ref1 = ref1;
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

	public int getIdx2() {
		return idx2;
	}

	public void setIdx2(int idx2) {
		this.idx2 = idx2;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRef1() {
		return ref1;
	}

	public void setRef1(int ref1) {
		this.ref1 = ref1;
	}

}
