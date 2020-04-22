
public class PhoneInfor {


    String name;            //이름
    String phoneNumber;     //전화번호
    String birthday;        //생년월일

    //생성자 오버로딩
    //생년월일은 선택적으로 저장 가능


    PhoneInfor(String name, String phoneNumber, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    PhoneInfor(String name, String phoneNumber) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;

        this(name, phoneNumber, null);
    }

//    입력받은 정보를 저장하는 메소드

    public static PhoneInfor saveData(String name, String phoneNumber, String birthday) {
        //생년월일을 받았을 경우와 아닌 경우
        if (birthday.equals("")) {
            PhoneInfor info = new PhoneInfor(name, phoneNumber);
            return info;
        } else {
            PhoneInfor info = new PhoneInfor(name, phoneNumber, birthday);
            return info;
        }
    }

    //입력받은 정보를 이름을 기준으로 검색하는 메소드

    public static void searchData(String searchName, PhoneInfor[] infors) {

        for (int i = 0; i < infors.length; i++) {
            //동명이인 전부 출력시 사용
            if (infors[i] == null)
                continue;

            //이름 검색
            if (searchName.equals(infors[i].name)) {
                System.out.println("======================================================");
                System.out.println(infors[i].toString());
                System.out.println("======================================================");
            }

            //제일 앞의 한명만 출력하고 싶은 경우
            //break;를 건다(그럴일 없겠지만)
        }
    }

    //입력받은 정보를 이름을 기준으로 삭제하는 메소드

    public static void deleteData(String searchName, PhoneInfor[] infors) {
        for (int i = 0; i < infors.length; i++) {

            if (infors[i].name.equals(searchName)) {
                System.out.println("======================================================");
                System.out.println(infors[i].name + "이 삭제되었습니다.");
                System.out.println("======================================================");

                //삭제후 인덱스 번호 하나씩 당겨오기1
                for (int j = i; j < 99; j++) {
                    infors[j] = infors[j + 1];
                    //  System.out.println(j + "번째" + infors[j]);
                }
                //인덱스 99번째 배열일때 삭제 처리
                if (infors[99] != null) {
                    infors[99] = null;
                }
                break;
            }
        }
    }

    //객체의 정보를 읽기 위해 toString메서드 재정의

    @Override
    public String toString() {
        return "고객정보[" +
                "이름='" + name + '\'' +
                ", 전화번호='" + phoneNumber + '\'' +
                ", 생일='" + birthday + '\'' +
                ']';
    }


}

