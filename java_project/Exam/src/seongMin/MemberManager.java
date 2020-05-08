package seongMin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MemberManager {

	String id;      		// 회원ID
	String title;			// 자료명
	String rentInfo;		// 대여상태
	String rentalDate;		// 대여일#
	String returnDate;		// 반납예정일#
	String reservDate;		// 예약일#
	String reservId;		// 예약자
	String dateOfExtens;	// 연장기간#
	String overdue;			// 연체일#
	 
	
	// 날짜포멧
	SimpleDateFormat format= new SimpleDateFormat ("yyyy-MM-dd");
	Date today= new Date();
	// 시간 더하기
	Calendar cal = Calendar.getInstance();
	
	// 회원리스트, 자료리스트 불러오기
	AdminManager admManager=AdminManager.getInstance();
	
	
	// 대여 - 리스트 생성자 (회원ID, 자료 title)
	MemberManager(String id, String title, String rentalDate, String returnDate) {

		this.id=id;      				// 대여한 회원ID
		this.title=title;				// 대여한 자료명
		this.rentInfo="대여중";			// 대여상태
		this.rentalDate=null; 			// 대여일
		this.returnDate=null;			// 반납일
		this.reservDate=null;			// 예약일
		this.reservId=null;				// 예약자
		this.dateOfExtens=null;			// 연장기간
		this.overdue=null;				// 연체기간
	}		
		

		
	// 대여 리스트 생성	
	ArrayList<MemberManager> rentalList=new ArrayList<>();
	
	
	
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 자료검색 ㅡ> 결과출력
	void showInfo() {
		
		 System.out.println("1.도서 | 2.DVD | 3. 게임");

         int selectNum = admManager.sc.nextInt();
         admManager.sc.nextLine();

         switch (selectNum) {
            case 1:		// Book 선택시
            	System.out.println("------------------------");
            	admManager.showBookInfo();
            	System.out.println("------------------------");

            	System.out.println("찾으시는 도서명을 입력해주세요.");
                this.title = admManager.sc.nextLine();
     			
     			int index = admManager.searchBookInfo(title);
     			
     			if(index<0) {
     				System.out.println("검색하신 자료의 정보가 없습니다.");
     				break;
     			} else {
     				admManager.getBooks().get(index).showAllinfo();
     				System.out.println("1.대여 | 2.예약");
     				selectNum = admManager.sc.nextInt();
     				admManager.sc.nextLine();
     			
     				switch (selectNum) {
                        
	                    case 1:  // 대여
	                            //로그인 상태일시 대여메서드 실행
	                    		if(admManager.loginCheck()) {
	                    		creatRentalList(); 
	                    			break;
	                    		} else {
	                            //비로그인 시
	                    			System.out.println("이용하시려면 로그인을 해 주세요.");
	                    			admManager.login();
	                    			break;
	                    		}
	                        
	                    case 2:  // 예약 	 
	                        	/* 예약 메서드 */ 
	                        	 break;
                
     					} //switch : case1(Book) : switch end
                    	 
     			}  //switch : case1(Book) : else end   	  
     			
     			
            case 2:		// DVD 선택시   
            	System.out.println("------------------------");
            	admManager.showDvdInfo();
            	System.out.println("------------------------");

            	System.out.println("찾으시는 DVD명을 입력해주세요.");
                this.title = admManager.sc.nextLine();
     			
     			index = admManager.searchDvdInfo(title);
     			
     			if(index<0) {
     				System.out.println("검색하신 자료의 정보가 없습니다.");
     				break;
     			} else {
     				admManager.getDvd().get(index).showAllinfo();
     				System.out.println("1.대여 | 2.예약");
     				selectNum = admManager.sc.nextInt();
     				admManager.sc.nextLine();
     			
     				switch (selectNum) {
                        
	                    case 1:  // 대여
	                            //로그인 상태일시 대여메서드 실행
	                    		if(admManager.loginCheck()) {
	                    		creatRentalList(); 
	                    			break;
	                    		} else {
	                            //비로그인 시
	                    			System.out.println("이용하시려면 로그인을 해 주세요.");
	                    			admManager.login();
	                    			break;
	                    		}
	                        
	                    case 2:  // 예약 	 
	                        	/* 예약 메서드 */ 
	                        	 break;
                
     					} //switch : case2(DVD) : switch end
                    	 
     			}  //switch : case2(DVD) : else end 
     			
     			
     			
            case 3:		// Game 선택시   
            	System.out.println("------------------------");
            	admManager.showDvdInfo();
            	System.out.println("------------------------");

            	System.out.println("찾으시는 DVD명을 입력해주세요.");
                this.title = admManager.sc.nextLine();
     			
     			index = admManager.searchDvdInfo(title);
     			
     			if(index<0) {
     				System.out.println("검색하신 자료의 정보가 없습니다.");
     				break;
     			} else {
     				admManager.getDvd().get(index).showAllinfo();
     				System.out.println("1.대여 | 2.예약");
     				selectNum = admManager.sc.nextInt();
     				admManager.sc.nextLine();
     			
     				switch (selectNum) {
                        
	                    case 1:  // 대여
	                            //로그인 상태일시 대여메서드 실행
	                    		if(admManager.loginCheck()) {
	                    		creatRentalList(); 
	                    			break;
	                    		} else {
	                            //비로그인 시
	                    			System.out.println("이용하시려면 로그인을 해 주세요.");
	                    			admManager.login();
	                    			break;
	                    		}
	                        
	                    case 2:  // 예약 	 
	                        	/* 예약 메서드 */ 
	                        	 break;
                
     					} //switch : case3(Game) : switch end
                    	 
     			}  //switch : case3(Game) : else end      			
            	 
         } //switch end
	} //showInfo() end
            	 
            	 
            	 

	
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList에 인스턴스 추가 
	void addRental(MemberManager info) {
		rentalList.add(info);
		
	}
	

	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 인스턴스 생성
	void creatRentalList() {
		
		MemberManager info = null;
		
			int index=admManager.loginCheckIndex();
		
			// 대여할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
			String id =admManager.getMember().get(index).getId(); 	// 로그인한 id
			// 회원 카운트 변경 
			admManager.getMember().get(index).rentalAvail -=1;   // 회원정보 : 대여가능권수 -1
			admManager.getMember().get(index).numOfRent +=1;		// 회원정보 : 대여권수 +1
			
			
			// 대여일 생성
			this.rentalDate=format.format(cal.getTime());
			System.out.println("대여일 : " + rentalDate);
			
			// 반납일 생성 : 대여일+7일
			cal.add(Calendar.DATE,7);
			String returnDate=format.format(cal.getTime());
			System.out.println("반납일 : "+returnDate);


			// 자료 카운트 변경
			// 만약에 선택한 타이틀이 book이면...book 카운트변경
			if(admManager.searchBookInfo(this.title)>0) {
				admManager.getBooks().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
				admManager.getBooks().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
				
				
			// 만약에 선택한 타이틀이 DVD이면...DVD 카운트변경
			} else if(admManager.searchDvdInfo(this.title)>0) {
				admManager.getDvd().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
				admManager.getDvd().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
			
			
			// 만약에 선택한 타이틀이 Game이면...Game 카운트변경
			} else if(admManager.searchGameInfo(this.title)>0) {
				admManager.getGame().get(index).numOfItem -=1;  	// 자료정보 : 재고 -1 numOfItem
				admManager.getGame().get(index).rentalCount +=1;  	// 자료정보 : 대여횟수 +1 rentalCount
			}
		
		// MemberManager 객체 생성
		info=new MemberManager(id, title, rentalDate, returnDate);
		
		
		// MemberManager 객체 ㅡ> 대여리스트에 추가 메서드 1-1. 호출.
		addRental(info); 
		System.out.println(id+"님 "+title+"자료가 대여가 완료되었습니다. ");
		System.out.println("대여일 : "+rentalDate+" | 반납예정일 : "+returnDate);
		
		
	}  // creatRentalList() end
	




//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 id로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	int searchRentalIndex(String id) {
		
		int searchRentalIndex=-1;
		
		for(int i=0; i<rentalList.size(); i++) {
			if(rentalList.get(i).id.equals(id)) {
				searchRentalIndex=i;
				break;
			}
		}
		return searchRentalIndex;
	}

	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// rentalList 에서 tilte로 검색하기(내 대여내역) ㅡ> 인덱스 반환
	int searchRentalIndexTitle(String title) {
		
		int searchRentalIndex=-1;
		
		for(int i=0; i<rentalList.size(); i++) {
			if(rentalList.get(i).title.equals(title)) {
				searchRentalIndex=i;
				break;
			}
		}
		return searchRentalIndex;
	}
	
	
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 내 대여내역 보기 : id로 받아서 ㅡ> rentalList 검색 ㅡ> 해당 리스트 반환
	public void showMyRentalList() {
		
		// 로그인 했던 아이디의 인덱스를 받아서
		int index=admManager.loginCheckIndex();
		
		// 그 아이디를 rentalList에서 찾고, 
		String id =admManager.getMember().get(index).getId();
		
		int rentalIndex=searchRentalIndex(id);
		
		// rentalList에서 해당 id의 대여내역만 출력
		rentalList.get(rentalIndex).showRentalListInfo();
		
	}
	
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
    // RentalList 전체 출력
    public void showAllRentalListInfo() {
        for (int i = 0; i < rentalList.size(); i++) {
        	rentalList.get(i).showRentalListInfo();
            System.out.println("----------------------------");
        }
    }
	
	
	// RentalList 기본 출력
    public void showRentalListInfo() {
		System.out.println("대여 ID : "+id+"\t\t대여 자료명 : "+title+"\t\t대여상태 :"+rentInfo);
		System.out.println("대여일: :"+rentalDate+"\t\t\t반납일 :"+returnDate);
		System.out.println("예약일: :"+reservDate+"\t\t\t예약자 :"+reservId);
		System.out.println("연장기간 : "+dateOfExtens+"\t\t연체기간: :"+overdue);
		System.out.println("--------------------------------------------------------------");  

    }
	
    

    
    
	
	
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	// 예약
	void reserve() {
		
		// 예약할 때 받을 정보 ㅡ> 로그인한 회원 Id, 대여할 자료명
		int index=admManager.loginCheckIndex();
		String reservId =admManager.getMember().get(index).getId(); 	// 로그인한 id
	
		searchRentalIndexTitle(this.title);
		
		// 예약일 생성
		String reservDate=format.format(cal.getTime());
		System.out.println("예약일 : " + reservDate);
		
		// 대여가능일 생성
		cal.add(Calendar.DATE,1);
		String rentalAvailDate=format.format(cal.getTime());
		System.out.println("대여가능일 : "+rentalAvailDate);
		
		
		System.out.println(title+"이(가) "+ reservDate + "일자로 예약 되었습니다.");
		System.out.println(rentalAvailDate + " 부터 대여 가능합니다.");
		
	} //reserve() end	
		
		
		
		
//		
//			날짜생성 고민..
//			try {
//				reservDate=format.parse("2020/ 05/ 05");
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	
	// 반납
	void itemReturn() {
		
		System.out.println("반납하고자하는 도서를 입력해주세요");
		String title = admManager.sc.nextLine();
		
		int index = admManager.loginCheckIndex();
		
		if(index<0) {	//반납실패
			System.out.println("반납하고자하는 "+ title +" 자료가 없습니다.");
		}else {
			//반납성공 		반납했는데 연체 or 정상.	
			title = rentalList.get(index).title;		// 책을 찾는다.
			
			String today = format.format(cal.getTime());
			//System.out.println(today);		// 오늘날짜
		    
			String strStartDate = this.rentalDate;	// rentalDate 로 바꿔야된다.
	        String strEndDate = today;
	        String strFormat = "yyyy-MM-dd";
	        
//	        SimpleDateFormat sdf2 = new SimpleDateFormat(strFormat);
	        
	        Date startDate = null;
	        Date endDate = null;
			try {
				startDate = format.parse(strStartDate);
				endDate = format.parse(strEndDate);		// today
			} catch (ParseException e) {
				e.printStackTrace();
			}	// rentalDate
            
            long gap = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
            gap = Math.abs(gap);
            //System.out.println(gap+"일");
	        
		    
			
		    
	        
	       
	        if( gap > 7) {	 // 연체.
				
				
	        	admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail = 0;		// 대여가능권수
				admManager.getMember().get(admManager.loginCheckIndex()).numOfExtens = 0;		// 연장가능횟수
				//numOfRent = ??		// 대여권수, 빌려간게 더 있을수도 있고 없을수도있고.	??
			
				System.out.println(title + "연체일수가 있습니다.");
				System.out.println(title + "연체일수는 " + gap + " 입니다.");
				System.out.println(overdue + "일 동안 자료를 대여하실 수 없습니다.");
				System.out.println("처리 : " + today);	
			}else if(gap < 7) {	// 연체 없음.
				
				returnDate = today;						
					
				System.out.println(title+"자료가 정상적으로 반납되었습니다.");
				System.out.println("처리 : " + today);	
				
				admManager.getMember().get(admManager.loginCheckIndex()).numOfRent --;			// 대여권수
				admManager.getMember().get(admManager.loginCheckIndex()).rentalAvail ++;		// 대여가능권수
				admManager.getMember().get(admManager.loginCheckIndex()).numOfExtens = 1;		// 연장가능횟수
				
			}
			
			// 대여가능으로 바꾼다.
			rentInfo = "대여가능";
			
		}	
			
	
	
	} //itemReturn끝.
	
	
	
	
		
	
	
	
} //class end

