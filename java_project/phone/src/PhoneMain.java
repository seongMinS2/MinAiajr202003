import java.util.Scanner;

public class PhoneMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        while(true){

            System.out.println("이름을 입력하세요. ");
            String name = sc.nextLine();

            System.out.println("주민등록번호를 입력하세요.");
            String num = sc.nextLine();

            System.out.println("생년월일을 입력하세요. 건너뛰시려면 엔터를 눌러주세요.");
            String birthday = sc.nextLine();

            //생년월일을 받았을 경우와 아닌 경우
            if(birthday.equals("")){

                PhoneInfor info = new PhoneInfor(name, num);
                System.out.println("이름: " + info.name
                        + "  전화번호: " + info.phoneNumber);
            }else {

                PhoneInfor info = new PhoneInfor(name, num, birthday);
                System.out.println("이름: " + info.name
                        + "  전화번호: " + info.phoneNumber
                        + " 생년월일: " + info.birthday);
            }
        }
    }
}
