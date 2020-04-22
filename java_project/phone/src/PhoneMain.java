
import java.util.Scanner;

public class PhoneMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    //사용자에게 입력받기위한 Scanner객체 생성

        PhoneInfor[] infors = new PhoneInfor[100];  // 고객정보 100개를 저장할 PhoneInfor타입 배열 생성

        //고객정보 100개를 저장 하는 루프를 돌림
        while (true) {

            //  정상작동 되는지 확인하는 반복문
            for (PhoneInfor e : infors) {
                System.out.println(e);
            }

            System.out.println("======================================================");
            System.out.println("1. 개인정보 저장 || 2. 검색 || 3. 삭제 || 4. 나가기");
            String num = sc.nextLine();

            //개인정보 저장
            if (num.equals("1")) {
                System.out.println("======================================================");
                System.out.println("이름을 입력하세요. ");
                String name = sc.nextLine();

                System.out.println("======================================================");
                System.out.println("전화번호를 입력하세요.");
                String phoneNumber = sc.nextLine();

                System.out.println("======================================================");
                System.out.println("생년월일을 입력하세요. 건너뛰시려면 엔터를 눌러주세요.");
                String birthday = sc.nextLine();

                //고객정보를 저장
                for (int i = 0; i < infors.length; i++) {
                    if (infors[i] == null) {
                        infors[i] = PhoneInfor.saveData(name, phoneNumber, birthday);
                        break;
                    }
                }


            // 검색
            } else if (num.equals("2")) {
                System.out.println("======================================================");
                System.out.println("이름을 입력해 주세요.");
                String searchName = sc.nextLine();


                //이름을 기준으로 검색하여 정보를 출력하는 메소드 실행
                PhoneInfor.searchData(searchName, infors);

                // 삭제 (이름을 기준으로 데이터(배열)를 찾아 삭제)
            } else if (num.equals("3")) {
                System.out.println("======================================================");
                System.out.println("이름을 입력해 주세요.");
                String searchName = sc.nextLine();

                PhoneInfor.deleteData(searchName, infors);

                // 나가기
            } else if (num.equals("4")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해 주세요.");
                continue;
            }
        }
    }
}