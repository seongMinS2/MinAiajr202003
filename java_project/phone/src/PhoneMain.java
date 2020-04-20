import java.util.Scanner;

public class PhoneMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    //사용자에게 입력받기위한 Scanner객체 생성

        PhoneInfor[] infors = new PhoneInfor[100];  // 고객정보 100개를 저장할 PhoneInfor타입 배열 생성

        int count = 0;      //배열의 인덱스를 읽기위한 count변수 생성

        //고객정보 100개를 저장하기 위해 루프를 돌림
        while(count != 100){
            
            System.out.println("이름을 입력하세요. ");
            String name = sc.nextLine();

            System.out.println("전화번호를 입력하세요.");
            String num = sc.nextLine();

            System.out.println("생년월일을 입력하세요. 건너뛰시려면 엔터를 눌러주세요.");
            String birthday = sc.nextLine();

            //생년월일을 받았을 경우와 아닌 경우
            if(birthday.equals("")){
                PhoneInfor info = new PhoneInfor(name, num);
                infors[count] = info;
                System.out.println("이름: " + info.name
                        + "  전화번호: " + info.phoneNumber);
            }else {
                PhoneInfor info = new PhoneInfor(name, num, birthday);
                infors[count] = info;
                System.out.println("이름: " + info.name
                        + "  전화번호: " + info.phoneNumber
                        + " 생년월일: " + info.birthday);
            }

            count++;
            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");

            //저장된 값 불러오기
            for(int i=0; i<count; i++){
                System.out.println(i + "번째 " + infors[i]);
            }

            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");
            System.out.println();
        }
    }
}
