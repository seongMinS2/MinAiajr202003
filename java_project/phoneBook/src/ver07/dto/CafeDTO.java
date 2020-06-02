package ver07.dto;

import java.sql.Date;

public class CafeDTO {
	
	private int idx1;
	private String name;            //이름
	private String phoneNumber;     //전화번호
	private String addr;           //주소
	private String email;          //이메일
	private Date regdate;
	private int idx4;
	private String cafaName;
	private String nicName;
	private int idx5;
	
	
	public CafeDTO() {}
	
	
	public CafeDTO(int idx1, String name, String phoneNumber, String addr, String email, Date regdate, int idx4,
			String cafaName, String nicName, int idx5) {
		this.idx1 = idx1;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
		this.regdate = regdate;
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
