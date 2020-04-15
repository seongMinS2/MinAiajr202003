package gwajae;

public class JavaTest05_13 {
    public static void main(String[] args) {
//     [13] 다음은 주어진 문자열(value)이 숫자인지를 판별하는 프로그램이다. (1)에 알맞은 코드를넣어서 프로그램을 완성하시오.

        String value = "12o34";

        char ch = ' ';

        boolean isNumber = true;

        // 반복문과 charAt(inti)를 이용해서 문자열의 문자를
        // 하나씩 읽어서 검사한다.

        for(int i=0; i < value.length() ;i++) {

            if ((80 <= value.charAt(i)) && (value.charAt(i) >= 89))
                isNumber = false;
            System.out.println(isNumber);
        }

        if (isNumber) {

            System.out.println(value+"는 숫자입니다.");

        } else {

            System.out.println(value+"는 숫자가 아닙니다.");

        }
    }

}
