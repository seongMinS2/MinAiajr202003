package ver05.v1;

import java.util.InputMismatchException;
import java.util.Scanner;

// PhoneInfo 타입의 배열로 친구정보를
// 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {

    // 1. 배열 선언
    private final PhoneInfor[] books;

    // 배열에 저장된 요소의 개수
    int numOfInfo;

    Scanner sc;

    // 생성자를 통해서 배열 생성, 요소의 개수 초기화
    PhoneBookManager(int num) {
        // 배열의 생성
        books = new PhoneInfor[num];
        // 요소 개수의 초기화
        numOfInfo = 0;
        //입력받을 스캐너객체 생성
        sc = new Scanner(System.in);
    }

    //싱글톤 패턴
    private static PhoneBookManager book = new PhoneBookManager(100);

    public static PhoneBookManager getInstance() {
        return book;
    }

    // 2. 배열에 정보 저장
    // 2.1 배열에 추가
    // 2.2 사용자로 부터 받은 데이터로 인스턴스 생성


    // 2.1 배열에 추가
    void addInfo(PhoneInfor info) {
        // 배열에 numOfInfo 숫자 -> index 로 참조값을 저장
        // 입력된 정보의 개수를 +1 증가 시킨다.
        books[numOfInfo++] = info;
    }


    // 2.2 사용자로 부터 받은 데이터로 인스턴스 생성
    void createInfo() {


        // 사용자 선택 번호

        int select = 0;

        while (true) {
            System.out.println(" 1.대학 2.회사 3.동호회");

            System.out.println("입력하고자 하는 번호를 입력해주세요.");

            try {
                select = sc.nextInt();

                //정상범위 1~3
                if (!(select >= 1 && select <= 3)) {

                    BadNumberException e = new BadNumberException("잘못된 메뉴 번호 입력");

                    throw e;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴 입력입니다. \n확인하시고 다시 입력해주세요.");
                //manager.sc.nextLine();
                continue;
            } catch (BadNumberException e) {
                System.out.println("메뉴범위를 벗어난 숫자 입력입니다. \n 다시 확인 후 입력해주세요.");
                continue;
            } catch (Exception e) {
                System.out.println("잘못된 메뉴입력입니다.");
                continue;
            } finally {
                sc.nextLine();
            }


            break;
        }

        PhoneInfor info = null;
        String name = null,
                phoneNumber = null,
                addr = null,
                email = null;

        while (true) {

            // 2.2.1 기본 정보 수집: 이름, 전번, 주소, 이메일
            System.out.println("이름을 입력해 주세요.");
            name = sc.nextLine();
            System.out.println("전화번호을 입력해 주세요.");
            phoneNumber = sc.nextLine();
            System.out.println("주소을 입력해 주세요.");
            addr = sc.nextLine();
            System.out.println("이메일을 입력해 주세요.");
            email = sc.nextLine();

        try {
            if (name.trim().isEmpty() ||
                    phoneNumber.trim().isEmpty() ||
                    addr.trim().isEmpty() ||
                    email.trim().isEmpty()
            ) {
                StringEmptyException e = new StringEmptyException();

                throw e;
            }
        } catch (StringEmptyException e) {
            System.out.println("기본정보는 공백없이 입력해 주세요.");
            System.out.println("다시 입력해 주세요.");
            continue;
        }
            break;
        }
        switch (select) {

            //PhoneInfor 객체가 추상화되어 사용할 수 없어짐
            //강사님도 기본정보 입력을 없애고 간다고 하심.
         /*   case MenuNaming.NOMAL:
                //2.2.2 기본 클래스로 인스턴스 생성
                info = new PhoneInfor(name, phoneNumber, addr, email);
                break;*/
            case MenuNum.UNIVERSITY:
                System.out.println("전공(학과)를 입력해주세요.");
                String major = sc.nextLine();
                System.out.println("학년 정보를 입력해주세요.");
                String grade = sc.nextLine();

                //2.2.3 대학 클래스로 인스턴스 생성
                info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);

                break;
            case MenuNum.COMPANY:
                System.out.println("회사의 이름을 입력해주세요.");
                String company = sc.nextLine();
                System.out.println("부서의 이름을 입력해주세요.");
                String dept = sc.nextLine();
                System.out.println("직무(직급)정보의 이름을 입력해주세요.");
                String job = sc.nextLine();

                //2.2.4 회사 클래스로 인스턴스 생성
                info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
                break;


            case MenuNum.CAFE:
                System.out.println("동호회 이름을 입려해주세요.");
                String cafeName = sc.nextLine();
                System.out.println("닉네임을 입려해주세요.");
                String nickName = sc.nextLine();


                //2.2.5 동호회 클래스로 인스턴스 생성
                info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
                break;


        }
        // 2.3 생성된 인스턴스를 배열에 저장

        addInfo(info);
    }

    // 3. 배열의 데이터 출력
    void showAllInfo() {

        // for each 반복 : 현재 프로그램에서는 사용 불가

        // for 반복문 : 반복의 횟수 지정이 가능 numOfInfo

        System.out.println("전체 정보를 출력합니다. ================");
        for (int i = 0; i < numOfInfo; i++) {
            books[i].showAllInfo();
            System.out.println("-------------------------------");
        }
    }

    // 4. 배열의 정보 검색 : 이름 기준
    int searchIndex(String name) {

        //정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
        int searchIndex = -1;

        //배열의 반복으로 name값을 비교해서 index 값을 찾는다.
        for (int i = 0; i < numOfInfo; i++) {
            if (books[i].name.equals(name)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    void showInfo() {
        System.out.println("검색하실 이름을 입력하세요.");
        String name = sc.nextLine();

        int index = searchIndex(name);
        if (index < 0) {
            System.out.println("검색하신 이름의 정보가 없습니다.");
        } else {
            System.out.println();
            books[index].showAllInfo();
            System.out.println();
        }
    }

    // 5. 배열의 정보를 삭제 : 이름 기준
    void deleteInfo() {
        System.out.println("삭제하고자하는 이름을 입력해주세요.");
        String name = sc.nextLine();

        int index = searchIndex(name);

        if (index < 0) {
            System.out.println("삭제하고자 하는이름의 정보가 없습니다.");
        } else {
            //삭제 위치에서 왼쪽으로 시프트
            for (int i = index; i < numOfInfo - 1; i++) {
                books[i] = books[i + 1];
            }
            //삭제가 되었으므로 요소의 개수도 -1
            numOfInfo--;
        }
    }

    // 6. 배열의 정보를 수정 : 이름 기준
    void editInfo() {

        System.out.println("변경하고자 하는 이름을 입력해주세요.");
        String name = sc.nextLine();

        int index = searchIndex(name);
        PhoneInfor info = null;

        if (index < 0) {
            System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
        } else {

            String editName = books[index].name;
            System.out.println("수정 데이터 입력을 시작합니다.");
            System.out.println("이름은 " + editName + "입니다.");
            System.out.println("전화번호를 입력해주세요.");
            String phoneNumber = sc.nextLine();
            System.out.println("주소를를 입력해주세요.");
            String addr = sc.nextLine();
            System.out.println("이메일을 입력해주세요.");
            String email = sc.nextLine();
            // 저장된 인스턴스가 : 대학, 회사, 동호회
            if (books[index] instanceof PhoneUnivInfo) {
                System.out.println("전공을 입력해주세요.");
                String major = sc.nextLine();
                System.out.println("학년을 입력해주세요.");
                String grade = sc.nextLine();

                info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
            } else if (books[index] instanceof PhoneCompanyInfo) {
                System.out.println("회사를 입력해주세요.");
                String company = sc.nextLine();
                System.out.println("부서를 입력해주세요.");
                String dept = sc.nextLine();
                System.out.println("직급을 입력해주세요.");
                String job = sc.nextLine();
                info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
            } else if (books[index] instanceof PhoneCafeInfo) {
                System.out.println("동호회 이름을 입력해주세요.");
                String cafeName = sc.nextLine();
                System.out.println("닉네임을 입력해주세요.");
                String nicName = sc.nextLine();

                info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nicName);
            }

            // 배열에 새로운 데이터를 저장
            books[index] = info;
        }
    }

}
