package seongMin;

public class MainLine {

    public static void main(String[] args) {

        boolean loginCheck = false;
        AdminManager manager = AdminManager.getInstance();

        while (true) {
            System.out.println("메인메뉴");
            System.out.println("1. 검색/대여 | 2.로그인 | 3.이용안내/회원가입 | 4.로그아웃");

            int selectNum = manager.sc.nextInt();

            switch (selectNum) {

                case 1:
                    System.out.println("1.도서 | 2.DVD | 3. 게임");

                    selectNum = manager.sc.nextInt();

                    switch (selectNum) {
                        case 1:
                            System.out.println("도서 대여 가능 목록");
                            manager.showBookInfo();
                            System.out.println("이곳에 자료 현황 목록 출력하면됨");
                            System.out.println("1.검색 2.뒤로가기");
                            selectNum = manager.sc.nextInt();
                            switch (selectNum) {
                                case 1:
                                    System.out.println("이곳에 상세 내역 출력");
                                    //로그인 됬을시
                                    System.out.println("1.대여 | 2.예약 | 3.반납 | 연장");
                                    selectNum = manager.sc.nextInt();
                                    //비로그인 시
                                    System.out.println("이용하시려면 로그인을 해 주세요.");                 
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("DVD 대여 가능 목록");
                            System.out.println("이곳에 자료 현황 목록 출력하면됨");
                            System.out.println("1.검색 2.뒤로가기");
                            selectNum = manager.sc.nextInt();
                            switch (selectNum) {
                                case 1:
                                    System.out.println("이곳에 상세 내역 출력");
                                    //로그인 됐을시
                                    System.out.println("1.대여 | 2.예약 | 3.반납 | 연장");
                                    selectNum = manager.sc.nextInt();
                                    if(loginCheck) {
                                        switch (selectNum) {
                                            case 1:
                                                System.out.println("대여란입니다.");
                                                break;
                                            case 2:
                                                System.out.println("예약란입니다.");
                                                break;
                                            case 3:
                                                System.out.println("반납란입니다.");
                                                break;
                                            case 4:
                                                System.out.println("연장란입니다.");
                                                break;
                                        }
                                    }else {
                                        //비로그인 시
                                        System.out.println("이용하시려면 로그인을 해 주세요.");
                                        break;
                                    }
                                case 2:
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("게임 대여 가능 목록");
                            System.out.println("이곳에 자료 현황 목록 출력하면됨");
                            System.out.println("1.검색 2.뒤로가기");
                            selectNum = manager.sc.nextInt();
                            switch (selectNum) {
                                case 1:
                                    System.out.println("이곳에 상세 내역 출력");
                                    //로그인 됬을시
                                    System.out.println("1.대여 | 2.예약 | 3.반납 | 연장");
                                    //비로그인 시
                                    System.out.println("이용하시려면 로그인을 해 주세요.");
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                    }
                case 2:

                    System.out.println("1. 회원 | 2.관리자");
                    selectNum = manager.sc.nextInt();

                    switch (selectNum){
                        case 1:
                            manager.login();
                            break;
                        case 2:
                            System.out.println("아이디를 입력해 주세요.");
                            System.out.println("비밀번호를 입력해 주세요.");
                            
                            break;
                    }
                    break;
                case 3:

                    System.out.println("1. 이용안내 | 2.회원가입");
                    selectNum = manager.sc.nextInt();

                    switch (selectNum){
                        case 1:
                            System.out.println("이용안내 출력");
                            break;
                        case 2:
                            manager.addInfo();
                            break;
                    }
                    break;
                case 4:

                    System.out.println("로그아웃 되었습니다. /n 프로그램 종료");
                    break;
            }

        }
    }
}
