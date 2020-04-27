package ver04.v1;

/*
Project : ver 0.30

        배열을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경.

        아래기능 삽입

        저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
        검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
        삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

        데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
        재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.
*/

import java.util.Scanner;

public class PhoneBookManager {

    final PhoneInfor[] pBooks;
    Scanner sc;
    //입력된 친구의 정보 개수 --> 입력된 배열을 요소 개수
    // 1. 참조할때 반복의 횟수
    // 2. 새로운 객체를 저장할때 index로 사용할 수 있다.
    int cnt;

    public PhoneBookManager() {

        // 배열 초기화
        pBooks = new PhoneInfor[100];
        //저장 갯수 초기화
        cnt = 0;
        // Scanner 객체 초기화
        sc = new Scanner(System.in);

    }

    // 저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
    // 배열에 PhoneInfor 타입의 참조값을 저장
    void addInfo(PhoneInfor info) {

        //배열에 요소 대입
        pBooks[cnt] = info;

        //등록된 정보의 개수를 증가
        cnt++;
    }

    // 사용자의 입력데이터로 PhoneInfor 객체 생성
    PhoneInfor createInstance() {

        PhoneInfor info = null;

        String name = null,
                phoneNumber = null,
                birthday = null,
                address = null,
                email = null,
                major = null,
                year = null,
                company = null;

        System.out.println("정보를 저장하기 위한 데이터를 저장합니다.");
        System.out.println("1. 친구정보 2. 학교정보 3.회사정보");
        int selectNum = sc.nextInt();
        sc.nextLine();
        switch (selectNum) {
            case 1:
                System.out.println("이름을 입력해주세요.>> ");
                name = sc.nextLine();

                System.out.println("전화번호를 입력해 주세요. >>");
                phoneNumber = sc.nextLine();

                System.out.println("생일을 입력해 주세요. >>");
                birthday = sc.nextLine();

                //사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분
                if (birthday == null || birthday.trim().isEmpty()) {
                    info = new PhoneInfor(name, phoneNumber);
                } else {
                    info = new PhoneInfor(name, phoneNumber, birthday);
                }

                break;

            case 2:
                System.out.println("이름을 입력해주세요.>> ");
                name = sc.nextLine();

                System.out.println("전화번호를 입력해 주세요. >>");
                phoneNumber = sc.nextLine();

                System.out.println("생일을 입력해 주세요. >>");
                birthday = sc.nextLine();

                //공통
                System.out.println("주소를 입력해 주세요. >>");
                address = sc.nextLine();

                System.out.println("이메일을 입력해 주세요. >>");
                email = sc.nextLine();

                //학교
                System.out.println("전공을 입력해 주세요. >>");
                major = sc.nextLine();

                System.out.println("년도를 입력해 주세요. >>");
                year = sc.nextLine();

                //사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분
                if (birthday == null || birthday.trim().isEmpty()) {
                    info = new PhoneUnivlnfor(name, phoneNumber,address,email,major,year);
        } else {
            info = new PhoneUnivlnfor(name, phoneNumber, birthday,address,email,major,year);
        }

        break;

            case 3:
                System.out.println("이름을 입력해주세요.>> ");
            name = sc.nextLine();

            System.out.println("전화번호를 입력해 주세요. >>");
            phoneNumber = sc.nextLine();

            System.out.println("생일을 입력해 주세요. >>");
            birthday = sc.nextLine();
            //공통
            System.out.println("주소를 입력해 주세요. >>");
            address = sc.nextLine();

            System.out.println("이메일을 입력해 주세요. >>");
            email = sc.nextLine();

            //회사
            System.out.println("회사를 입력해 주세요. >>");
            company = sc.nextLine();

            //사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분
            if (birthday == null || birthday.trim().isEmpty()) {
                info = new PhoneCompaanyInfor(name, phoneNumber,address,email,company);
            } else {
                info = new PhoneCompaanyInfor(name, phoneNumber, birthday,address,email,company);
            }

            break;
        }

        return info;
    }

    // 전체 리스트 출력
    void showAllData() {
        // 전체 데이터 -> 입력된 데이터의 개수 cnt

        for (int i = 0; i < cnt; i++) {
            pBooks[i].showInfo();
            System.out.println("------------------");
        }


    }

    //배열에서 이름을 기준으로 검색후 index 값을 반환
    int searchIndex(String name) {

        int searchIndex = -1;
        //사용자가 입력한 이름으로 배열에 요소를 검색 -> index
        for (int i = 0; i < cnt; i++) {
            if (pBooks[i].checkName(name)) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    //검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를출력
    //배열의 요소(PhoneInfor)의 name속성 값으로  배열의 요소
    void searchInfo() {
        System.out.println("검색하고자하는 이름을 입력해주세요.");
        String name = sc.nextLine();

        int searchIndex = searchIndex(name);
        if (searchIndex < 0) {
            System.out.println("찾으시는 이름의 데이터가 존재하지 않습니다.");
        } else {
            pBooks[searchIndex].showInfo();
        }
    }

    void deleteInfo() {
        System.out.println("삭제 하고자하는 이름을 입력해주세요.");
        String name = sc.nextLine();

        int searchIndex = -1;
        //사용자가 입력한 이름으로 배열에 요소를 검색 -> index
        for (int i = 0; i < cnt; i++) {
            if (pBooks[i].checkName(name)) {
                searchIndex = i;
                break;
            }

        }

        if (searchIndex < 0) {
            System.out.println("찾으시는 데이터가 존재하지 않습니다.");
        } else {
            for (int i = searchIndex; i < cnt - 1; i++) {
                pBooks[i] = pBooks[i + 1];
            }
        }
        cnt--;
        System.out.println("요청하신 이름의 정보를 삭제했습니다.");
    }
}
