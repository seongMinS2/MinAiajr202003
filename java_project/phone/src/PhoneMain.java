
import java.util.Scanner;

public class PhoneMain {
    /*
            각자 기능들 메서드를 만들어 빼기.

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    //사용자에게 입력받기위한 Scanner객체 생성

        PhoneInfor[] infors = new PhoneInfor[100];  // 고객정보 100개를 저장할 PhoneInfor타입 배열 생성

        int count = 0;      //배열의 인덱스를 읽기위한 count변수 생성

        //고객정보 100개를 저장하기 위해 루프를 돌림
        while (true) {

//            정상작동 되는지 확인하는 반복문
//            for(PhoneInfor e: infors){
//                System.out.println(e);
//            }

            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");
            System.out.println("1. 개인정보 저장 || 2. 검색 || 3. 삭제 || 4. 나가기");
            String num = sc.nextLine();

            if (num.equals("1")) {
                System.out.println("------------------------------------------------------");
                System.out.println("------------------------------------------------------");
                System.out.println("이름을 입력하세요. ");
                String name = sc.nextLine();

                System.out.println("------------------------------------------------------");
                System.out.println("------------------------------------------------------");
                System.out.println("전화번호를 입력하세요.");
                String phoneNumber = sc.nextLine();

                System.out.println("------------------------------------------------------");
                System.out.println("------------------------------------------------------");
                System.out.println("생년월일을 입력하세요. 건너뛰시려면 엔터를 눌러주세요.");
                String birthday = sc.nextLine();

                //생년월일을 받았을 경우와 아닌 경우
                if (birthday.equals("")) {
                    PhoneInfor info = new PhoneInfor(name, phoneNumber);
                    //배열루프를 돌려 빈(null)값인 배열인덱스에 고객 객체 데이터 저장
                    for(int i = 0; i < infors.length; i++) {
                        if(infors[i] == null) {
                            infors[i] = info;
                            break;
                        }
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("------------------------------------------------------");
                    System.out.println("이름: " + info.name
                            + "  전화번호: " + info.phoneNumber);
                } else {
                    PhoneInfor info = new PhoneInfor(name, phoneNumber, birthday);
                    //배열루프를 돌려 빈(null)값인 배열인덱스에 고객 객체 데이터 저장
                    for(int i = 0; i < infors.length; i++) {
                        if(infors[i] == null) {
                            infors[i] = info;
                            break;
                        }
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println("------------------------------------------------------");
                    System.out.println("                저장되었습니다.\n이름: " + info.name
                            + "  전화번호: " + info.phoneNumber
                            + " 생년월일: " + info.birthday);
                }
                count++;
            } else if (num.equals("2")) {
                System.out.println("------------------------------------------------------");
                System.out.println("------------------------------------------------------");
                System.out.println("이름을 입력해 주세요.");
                String searchName = sc.nextLine();
                //이름을 기준으로 검색하여 정보를 출력

                for (int i = 0; i < infors.length; i++) {
                    if (infors[i] == null)
                        continue;
                    if (searchName.equals(infors[i].name)) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("------------------------------------------------------");
                        System.out.println(infors[i].toString());
                        break;
                    }
                }

                //삭제 코드(이름을 기준으로 데이터(배열)를 찾아 삭제)
            } else if (num.equals("3")) {
                System.out.println("------------------------------------------------------");
                System.out.println("------------------------------------------------------");
                System.out.println("이름을 입력해 주세요.");
                String searchName = sc.nextLine();
                //이름을 기준으로 검색하여 정보를 출력
                for (int i = 0; i < infors.length; i++) {
                    if (infors[i].name.equals(searchName)) {
                        System.out.println("------------------------------------------------------");
                        System.out.println("------------------------------------------------------");
                        System.out.println(infors[i].name + "이 삭제되었습니다.");
                        //삭제후 인덱스 번호 하나씩 당겨오기
                        for (int j = i; j < 99; j++) {
                            infors[j] = infors[j + 1];
                            System.out.println(j + "번째" + infors[j]);
                        }
                        break;
                    }
                }
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