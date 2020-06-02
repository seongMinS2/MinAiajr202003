package ver07;

import java.util.InputMismatchException;

import ver07.exception.BadNumberException;
import ver07.service.PhoneBookManager;
import ver07.veiw.Menu;
import ver07.veiw.MenuNum;

public class PhoneBookMain {
    public static void main(String[] args) {

        //PhoneBookManager manager = new PhoneBookManager(100);
        PhoneBookManager manager = PhoneBookManager.getInstance();

        while (true) {
            Menu.showMenu();

            int select = 0;
            try {
                select = manager.sc.nextInt();

                // 정상 범위는 1~6
                // MenuNum.CREATE~MenuNum.EXIT
                if (!(select >= MenuNum.CREATE && select <= MenuNum.EXIT)) {
                    BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 경우입니다. \n 다시 확인후 입력해주세요.");

                    //강제적인 예외 발생;
                    throw e;
                }
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
                manager.sc.nextLine();
            }

            switch (select) {
                case MenuNum.CREATE:
                    manager.createInfo();	// 생성 완료
                    break;
                case MenuNum.SEARCH:
                    manager.showInfo();  // 내부표기로 변환할 수 없음, 동호회쪽 손봐야함
                    break;
                case MenuNum.DELETE:
                    manager.deleteInfo();	// 삭제 완료
                    break;
                case MenuNum.EDIT:
                    //manager.editInfo();
                    break;
                case MenuNum.SHOW_ALL:
                    //manager.showAllInfo();	// 전체 출력 완료
                	//manager.showCafeInfo();	// 동호회 출력 완료
                	//manager.showCompanyInfo();  // 회사 출력 완료
                	manager.showUnivInfo();		//학교 출력 완료
                    break;
                case MenuNum.EXIT:
                    break;
            }
        }
    }
}
