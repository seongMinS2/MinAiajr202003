package seongMin;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminManager {

	private ArrayList<Member> member;
    Scanner sc;

    //아이템배열 선언
    private ArrayList<Book> books;

	private ArrayList<DVD> dvd;
    private ArrayList<Game> game;


    private AdminManager() {
        this.member = new ArrayList<Member>();
        this.books = new ArrayList<>();
        this.dvd = new ArrayList<>();
        this.game = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    //어드민매니저 객체 싱글톤 구현
    private static AdminManager manager = new AdminManager();

    public static AdminManager getInstance() {
        return manager;
    }


    public ArrayList<Member> getMember() {
		return member;
	}


	public ArrayList<Book> getBooks() {
		return books;
	}


	public ArrayList<DVD> getDvd() {
		return dvd;
	}


	public ArrayList<Game> getGame() {
		return game;
	}


    //회원정보보기
    //객체 전체 목록 출력
    public void showInfo() {
        for (int i = 0; i < member.size(); i++) {
            member.get(i).showAllInfo();
            System.out.println("----------------------------");
        }
    }

    public void addInfo() {
        String id = null, pw = null, pw2 = null, name = null, phoneNum = null, addr = null, email = null;
        int age = 0;

        //비밀번호 확인 루프를 위한 변수
        boolean checkPw = true;

        System.out.println("회원가입을 시작합니다.");
        System.out.println("사용하실 아이디를 입력해 주세요.");

        id = sc.nextLine();
        sc.nextLine();

        while (checkPw) {
            System.out.println("비밀번호를 입력해 주세요.");
            pw = sc.nextLine();
            System.out.println("다시한번 입력해 주세요.");
            pw2 = sc.nextLine();
            if (pw.equals(pw2)) {
                System.out.println("이름을 입력해 주세요.");
                name = sc.nextLine();
                System.out.println("전화번호를 입력해 주세요.");
                phoneNum = sc.nextLine();
                System.out.println("주소를 입력해 주세요.");
                addr = sc.nextLine();
                System.out.println("이메일을 입력해 주세요.");
                email = sc.nextLine();

                //입력받은 데이터 저장
                Member info = new Member(name, age, phoneNum, addr, email, id, pw);
                member.add(info);

                System.out.println("회원가입이 정상적으로 완료되었습니다.");
                //저장후 무한루프를 빠져나오기 위해 checkPw를 false로 변경
                System.out.println(member.get(0));
                checkPw = false;
            } else {
                System.out.println("입력하신 비밀번호가 다릅니다. 다시 입력해 주세요.");
                continue;
            }
        }
    }


    // 로그인체크해서 로그인상태인지 아닌지 반환
    boolean loginCheck() {

    	boolean loginCheck = false;

    	for(int i =0; i<this.member.size();i++) {
    		if(!this.member.get(i).loginCheck) {
    			loginCheck =true;
    			break;
    		}
    	}

    	return loginCheck;
    }


    // 로그인체크해서 인덱스 반환
    int loginCheckIndex() {

    	int loginCheckIndex = -1;

    	for(int i =0; i<this.member.size();i++) {
    		if(!this.member.get(i).loginCheck) {
    			loginCheckIndex = i;
    			break;
    		}
    	}

    	return loginCheckIndex;
    }





    int searchIndex(String id) {

        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 id값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).checkId(id)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    public void editInfo() {

        System.out.println("수정하실 분의 아이디를 선택해 주세요.");
        String id = sc.nextLine();

        int index = searchIndex(id);

        MemberInfo info = null;

        System.out.println("1. 비밀번호 | 2. 전화번호 | 3.주소 | 4. 이메일");

        int selectNum = sc.nextInt();
        switch (selectNum) {
            case 1:
                boolean check = true;
                while (check) {
                    System.out.println("변경하실 비밀번호를 입력해 주세요.");
                    String pw1 = sc.nextLine();
                    System.out.println("다시 입력해주세요.");
                    String pw2 = sc.nextLine();

                    //아이디,비밀번호정보 받고 수정해야함
                    if (pw1.equals(pw2)) {
                        member.get(index).setPw(pw1);
                        System.out.println("비밀번호 변경이 완료되었습니다.");
                        check = false;
                        break;
                    } else {
                        System.out.println("비밀번호가 맞지 않습니다. 다시 입력해 주세요.");
                        continue;
                    }
                }
            case 2:
                System.out.println("변경하실 전화번호를 입력해 주세요.");
                String phoneNumber = sc.nextLine();

                member.get(index).phoneNum = phoneNumber;
                break;
            case 3:
                System.out.println("변경하실 주소를 입력해 주세요.");
                String addr = sc.nextLine();

                member.get(index).addr = addr;
                break;
            case 4:
                System.out.println("변경하실 이메일을 입력해 주세요.");
                String email = sc.nextLine();

                member.get(index).email = email;
                break;
        }
    }

    public void deleteInfo() {
        System.out.println("삭제하실분의 아이디를 입력해 주세요.");
        String id = sc.nextLine();

        int index = searchIndex(id);

        member.remove(index);

    }

    public void login() {
        boolean check = true;
        while (check) {
            System.out.println("아이디를 입력해 주세요.");

            String id = sc.nextLine();
            sc.nextLine();
            int index = searchIndex(id);
            if (index >= 0) {
                System.out.println("비밀번호를 입력해 주세요.");
                String pw = sc.nextLine();
                if (member.get(index).getPw().equals(pw)) {
                    System.out.println("로그인이 완료되었습니다.");
                    member.get(index).loginCheck = true;
                    check = false;
                    break;
                } else {
                    System.out.println("비밀번호를 다시 입력해 주세요.");
                    continue;
                }
            } else {
                System.out.println("입력하신 아이디가 없습니다. 다시 입력해주세요.");
                continue;
            }
        }
    }

    public void logOut() {

        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).loginCheck == true) {
                member.get(i).loginCheck = false;
                System.out.println("로그아웃 되었습니다.");
                break;
            } else {
                System.out.println("로그인된 계정이 없습니다.");
                break;
            }
        }

    }

    public void adminLogin() {
    	boolean check = true;
    	while (check) {
    		System.out.println("아이디를 입력해 주세요.");

    		String id = sc.nextLine();
    		sc.nextLine();
        int index = searchIndex(id);

        if (index > 0) {
            System.out.println("비밀번호를 입력해 주세요.");
            String pw = sc.nextLine();
            if (member.get(index).getPw().equals(pw)) {
                System.out.println("로그인이 완료되었습니다.");
                member.get(index).loginCheck = true;
                check = false;
                break;
            } else {
                System.out.println("비밀번호를 다시 입력해 주세요.");
                continue;
            }
        } else {
            System.out.println("입력하신 아이디가 없습니다. 다시 입력해주세요.");
            continue;
        }
    }

    }

    public void adminLogOut() {
    	for (int i = 0; i < member.size(); i++) {
            if (member.get(i).loginCheck == true) {
                member.get(i).loginCheck = false;
                System.out.println("로그아웃 되었습니다.");
                break;
            } else {
                System.out.println("로그인된 계정이 없습니다.");
                break;
            }
        }

    }

    //책입니다---------------------------------------------

    //자료관리
    //도서 정보보기
    public void showBookInfo() {
        System.out.println("책정보 출력");
        for(int i=0;i<books.size();i++) {
            books.get(i).showAllinfo();
            System.out.println("-------------");
        }


    }

    //create로 이동
//	@Override
    //도서 정보넣기
//	public void addBookInfo(Book info) {
//		//배열에 추가
//		books.add(info);
//
//
//	}
    //도서정보수정
    public void editBookInfo() {

        System.out.println("변경하고자하는 책 이름을 입력해주세요");
        String title = sc.nextLine();

        int index = searchBookInfo(title);


        if(index<0) {
            System.out.println("찾으시는 책의 정보가 존재하지 않습니다.");
        }
        else {
            String editTitle = books.get(index).title;

            System.out.println("수정 사항을 입력합니다");
            System.out.println("책 이름은: "+editTitle+"입니다");
            System.out.println("자료위치는");
            String localData = sc.nextLine();

            books.get(index).localData = localData;


        }
    }
    //도서정보삭제
    public void deleteBookInfo() {
        System.out.println("삭제하고자 하는 책 이름을 선택하여주세요");
        String title = sc.nextLine();
        int index = searchBookInfo(title);

        if(index<0) {
            System.out.println("삭제하고자 하는 책이 존재하지 않습니다.");
        }else {
            books.remove(index);
        }

    }

    //도서정보 검색
    public int searchBookInfo(String title) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    //DVD입니다----------------------------------------------
    //DVD정보출력
    public void showDvdInfo() {
        System.out.println("DVD정보 출력");
        for(int i=0;i<dvd.size();i++) {
            dvd.get(i).showAllinfo();
            System.out.println("-------------");
        }



    }

    //create로 이동
//DVD추가
//	@Override
//	public void addDvdInfo(DVD info) {
//		dvd.add(info);
//
//	}

    //DVD수정
    public void editDvdInfo() {
        System.out.println("변경하고자하는 DVD 이름을 입력해주세요");
        String title = sc.nextLine();

        int index = searchDvdInfo(title);

        if(index<0) {
            System.out.println("찾으시는 책의 정보가 존재하지 않습니다.");
        }
        else {
            String editTitle = dvd.get(index).title;

            System.out.println("수정 사항을 입력합니다");
            System.out.println("DVD 이름은: "+editTitle+"입니다");
            System.out.println("자료위치는");
            String localData = sc.nextLine();

            dvd.get(index).localData=localData;
        }

    }
    //DVD삭제
    public void deleteDvdInfo() {
        System.out.println("삭제하고자 하는 DVD 이름을 선택하여주세요");
        String title = sc.nextLine();
        int index = searchDvdInfo(title);

        if(index<0) {
            System.out.println("삭제하고자 하는 DVD가 존재하지 않습니다.");
        }else {
            dvd.remove(index);
        }


    }
    //DVD검색
    public int searchDvdInfo(String title) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < game.size(); i++) {
            if (dvd.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    //게임입니다---------------------------------------------------
    //게임보기
    public void showGameInfo() {
        System.out.println("게임정보 출력");
        for(int i=0;i<game.size();i++) {
            game.get(i).showAllinfo();
            System.out.println("-------------");
        }

    }
    //create쪽으로 넣음
//게임추가
//	@Override
//	public void addGameInfo(Game info) {
//		game.add(info);
//
//	}
//게임수정
    public void editGameInfo() {
        System.out.println("변경하고자하는 게임 이름을 입력해주세요");
        String title = sc.nextLine();

        int index = searchGameInfo(title);


        if(index<0) {
            System.out.println("찾으시는 게임의 정보가 존재하지 않습니다.");
        }
        else {
            String editTitle = game.get(index).title;

            System.out.println("수정 사항을 입력합니다");
            System.out.println("게임 이름은: "+editTitle+"입니다");
            System.out.println("자료위치는");
            String localData = sc.nextLine();
            game.get(index).localData=localData;

        }

    }
    //게임삭제
    public void deleteGameInfo() {
        System.out.println("삭제하고자 하는 게임 이름을 선택하여주세요");
        String title = sc.nextLine();
        int index = searchDvdInfo(title);

        if(index<0) {
            System.out.println("삭제하고자 하는 게임이 존재하지 않습니다.");
        }else {
            dvd.remove(index);
        }

    }
    //게임검색
    public int searchGameInfo(String title) {
        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 title값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < game.size(); i++) {
            if (game.get(i).title.equals(title)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    //정보 입력단계------------------------------------------------------
    //책 정보 입력
    public Book createBookInfo() {

        Book info =null;

        String title=null;
        String genre=null;
        String localData=null;
        String rentInfo=null;

        // 기본정보 수집: 책이름, 장르, 책위치, 대여상태

        System.out.println("책이름을 입력해주세요.");
        title = sc.nextLine();

        System.out.println("장르을 입력해주세요.");
        genre = sc.nextLine();

        System.out.println("자료위치를 입력해주세요.");
        localData = sc.nextLine();

        System.out.println("대여상태를 입력해주세요.");
        rentInfo = sc.nextLine();


        System.out.println("저자를 입력해주세요");
        String author = sc.nextLine();
        System.out.println("연령제한 입력해주세요");
        int limitAge = sc.nextInt();
        System.out.println("설명을 입력해주세요");
        String story = sc.nextLine();	//설명
        System.out.println("출판일을 입력해주세요");
        String launchDate= sc.nextLine();	//출판일



        info = new Book(title, genre, localData,
                author, limitAge, story, launchDate);

        //배열에 추가
        books.add(info);
        return info;

    }
    //DVD 정보 입력
    public DVD createDvdInfo() {
        DVD info =null;

        String title=null;
        String genre=null;
        String localData=null;
        String rentInfo=null;

        // 기본정보 수집: DVD이름, 장르, DVD위치, 대여상태

        System.out.println("책이름을 입력해주세요.");
        title = sc.nextLine();

        System.out.println("장르을 입력해주세요.");
        genre = sc.nextLine();

        System.out.println("자료위치를 입력해주세요.");
        localData = sc.nextLine();

        System.out.println("대여상태를 입력해주세요.");
        rentInfo = sc.nextLine();


        System.out.println("감독를 입력해주세요");
        String foreman = sc.nextLine();

        System.out.println("상영시간을 입력해주세요");
        String runingTime = sc.nextLine();

        System.out.println("연령제한 입력해주세요");
        int limitAge = sc.nextInt();

        System.out.println("설명을 입력해주세요");
        String story = sc.nextLine();	//설명

        System.out.println("출판일을 입력해주세요");
        String launchDate= sc.nextLine();	//출판일



        //DVD 클래스로 인스턴스생성
        info = new DVD(title, genre, localData, rentInfo, foreman,
                runingTime, limitAge, story, launchDate);

        //배열에 추가
        dvd.add(info);

        return info;
    }
    //Game 정보 입력
    public Game CreateGameInfo() {
        Game info =null;

        String title=null;
        String genre=null;
        String localData=null;
        String rentInfo=null;

        // 기본정보 수집: 게임이름, 장르, 게임위치, 대여상태

        System.out.println("책이름을 입력해주세요.");
        title = sc.nextLine();

        System.out.println("장르을 입력해주세요.");
        genre = sc.nextLine();

        System.out.println("자료위치를 입력해주세요.");
        localData = sc.nextLine();

        System.out.println("대여상태를 입력해주세요.");
        rentInfo = sc.nextLine();


        System.out.println("제작자를 입력해주세요");
        String producer = sc.nextLine();

        System.out.println("연령제한 입력해주세요");
        int limitAge = sc.nextInt();

        System.out.println("설명을 입력해주세요");
        String story = sc.nextLine();	//설명

        System.out.println("출판일을 입력해주세요");
        String launchDate= sc.nextLine();	//출판일





        //2.2.3 Book 클래스로 인스턴스생성
        info = new Game(title, genre, localData, rentInfo,
                producer, limitAge, story, launchDate);

        //배열에 추가
        game.add(info);
        return info;
    }
}
