package seongMin;

public interface RentalInterface {
	
	//1. 회원관리
	//1.1 회원정보보기
	void showInfo();
	//1.2 회원정보추가
	void addInfo();
	//1.3 회원정보수정
	void editInfo();
	//1.4 회원정보삭제
	void deleteInfo();
	//1.5 회원로그인
	void login();
	//1.6 관리자 로그인
	void adminLogin();
	
	
	
	
	//자료관리
	//2.1도서보기
	void showBookInfo();
	//2.2도서자료추가
	void addBookInfo();
	//2.3도서자료수정
	void editBookInfo();
	//2.4도서자료삭제
	void deleteBookInfo();
	
	//자료관리
	//3.DVD보기
	void showDvdInfo();
	//3.DVD자료추가
	void addDvdInfo();
	//3.3DVD자료수정
	void editDvdInfo();
	//3.4DVD자료삭제
	void deleteDvdInfo();
	
	//자료관리
	//4.1게임보기
	void showGameInfo();
	//4.2게임자료추가
	void addGameInfo();
	//4.3게임자료수정
	void editGameInfo();
	//4.4게임자료삭제
	void deleteGameInfo();
}
