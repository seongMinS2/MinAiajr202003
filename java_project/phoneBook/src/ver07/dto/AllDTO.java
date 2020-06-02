package ver07.dto;

import java.sql.Date;

public class AllDTO {
	private int idx1;
	private String name;            //이름
	private String phoneNumber;     //전화번호
	private String addr;           //주소
	private String email;          //이메일
	private Date regdate;
	private int idx2;
	private String major;
	private int year;
	private int ref1;
	private int idx3;
	private String company;
	private int ref2;
	private int idx4;
	private String cafaName;
	private String nicName;
	private int idx5;
	
	
	public AllDTO() {}
	
	public AllDTO(int idx1, String name, String phoneNumber, String addr, String email, Date regdate, int idx2,
			String major, int year, int ref1, int idx3, String company, int ref2, int idx4, String cafaName,
			String nicName, int idx5) {
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
		this.idx3 = idx3;
		this.company = company;
		this.ref2 = ref2;
		this.idx4 = idx4;
		this.cafaName = cafaName;
		this.nicName = nicName;
		this.idx5 = idx5;
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
	public int getIdx4() {
		return idx4;
	}
	public void setIdx4(int idx4) {
		this.idx4 = idx4;
	}
	public String getCafaName() {
		return cafaName;
	}
	public void setCafaName(String cafaName) {
		this.cafaName = cafaName;
	}
	public String getNicName() {
		return nicName;
	}
	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
	public int getIdx5() {
		return idx5;
	}
	public void setIdx5(int idx5) {
		this.idx5 = idx5;
	}
	
	
}
