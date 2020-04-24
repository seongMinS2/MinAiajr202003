package ver04.v1;

import java.util.Scanner;

public class PhoneBookMain {
    public static void main(String[] args) {

        PhoneBookManager manager = new PhoneBookManager();

        Scanner sc = new Scanner(System.in);

        while (true) {

            Menu.showMenu();
            int selectNum = sc.nextInt();
            sc.nextLine();
            switch (selectNum) {
                // 사용자의 입력 데이터를 인스턴스 생성
                // 정보를 배열에 저장
                case 1:
                    PhoneInfor info = manager.createInstance();
                    //PhoneCompaanyInfor info = manager.createInstance();
                    //Phoneunivlnfor info = manager.createInstance();
                    manager.addInfo(info);
                    break;
//                검색
                case 2:
                    manager.searchInfo();
                    break;
//                이름으로 검색후 삭제
                case 3:
                    manager.deleteInfo();
                    break;
//                전체 리스트 출력
                case 4:
                    manager.showAllData();
                    break;
                case 5:
                    //return;
                    System.exit(0);
            }

//            // 정보를 배열에 저장


        }


    }
}
