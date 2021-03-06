package data;

import master.RentalList;

public class UserList4 extends RentalList {
	
	String id;      		// 회원ID
	String title;			// 자료명
	String rentInfo;		// 대여상태
	String rentalDate;		// 대여일#
	String returnDate;		// 반납예정일#
	String returnLimit;		// 반납일
	String reservDate;		// 예약일#
	String reservId;		// 예약자
	String extendDate;		// 연장된 반납일#
	String overdue;			// 연체일
	
	public UserList4(){
		this.id="qkrtjdals";  						// 대여한 회원ID
		this.title="더 해빙";							// 대여한 자료명
		this.rentInfo="대여가능";						// 대여상태
		this.rentalDate="2020-05-17"; 				// 대여일#
		this.returnLimit ="2020-05-24";				// 반납예정일#
		this.returnDate="2020-05-20";				// 반납일#
		this.reservDate="2020-05-15";				// 예약일#
		this.reservId=" ";							// 예약자
		this.extendDate=" ";						// 연장된 반납일#
		this.overdue=" ";							// 연체기간#
	}

}
