package data;

import master.RentalList;

public class UserList14 extends RentalList {
	
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
	
	public UserList14(){
		this.id="dlawodud1";  						// 대여한 회원ID
		this.title="스플레툰2";						// 대여한 자료명
		this.rentInfo="대여가능";						// 대여상태
		this.rentalDate="2020-05-04"; 				// 대여일#
		this.returnLimit ="2020-05-11";				// 반납예정일#
		this.returnDate="2020-05-10";				// 반납일#
		this.reservDate=" ";						// 예약일#
		this.reservId="qkraudgns";					// 예약자
		this.extendDate=" ";						// 연장된 반납일#
		this.overdue=" ";							// 연체기간#
	}

}
