package friend;

import java.util.InputMismatchException;

public class FriendMain {
    public static void main(String[] args) {

        //FriendInfoHandler handler = new FriendInfoHandler(10);
        FriendInfoHandler handler = FriendInfoHandler.getInstance();

        while (true) {
            System.out.println("===메뉴를 선택해 주세요 ==========");
            System.out.println("1. 고교친구 저장");
            System.out.println("2. 대학친구 저장");
            System.out.println("3. 기본 정보 출력");
            System.out.println("4. 전체 정보 출력");
            System.out.println("5. 종료");
            System.out.println("==================================");

            int choice = 0;
            //1
            try {

                choice = handler.sc.nextInt();
                handler.sc.nextLine();

            } catch (InputMismatchException e){  // inputMissmatchException 인스턴스 전달
                System.out.println("정상적인 메뉴의 번호 입력이 되지 않았습니다.");
                System.out.println("메뉴를 다시 입력해주세요.");
                handler.sc.nextLine();
                continue;
            } catch (Exception e){
                System.out.println("예외 발생");
                handler.sc.nextLine();
                continue;
            }

        switch (choice) {

            case Menu.INSERT_HEIGHT: case Menu.INSERT_UNIV:
                handler.addFriend(choice);
                break;
            case Menu.INSERT_NOMAL:
                handler.showAllSimpleData();
                break;
            case Menu.INSERT_ALL:
                handler.showAllData();
                break;
            case Menu.INSERT_EXIT:
                System.out.println("프로그램을 종료합니다.");
                return;
        }

        }
    }
}
