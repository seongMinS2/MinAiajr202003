package selfTest.ex;

public class StringBufferInsert {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Java 만세!!");

        System.out.println("원본 문자열 : " + str);

        System.out.println(str.insert(4, "Script"));

        System.out.println("insert() 메소드 호출 후 원본 문자열 : " + str);

        StringBuffer str1 = new StringBuffer("ABCDEFGHIJKLMN");

        System.out.println(str1.reverse());


        StringBuffer str2 = new StringBuffer("990929-1010123");

        System.out.println(str2.delete(6,7));

        StringBuffer str3 = new StringBuffer(("990929-1010123"));

        System.out.println(str3.deleteCharAt(6));


        String strr = new String(" Java     ");

        System.out.println("원본 문자열 : " + strr);



        System.out.println(strr + "sdfsd");

        System.out.println(strr.trim() + "f");

        System.out.println("trim() 메소드 호출 후 원본 문자열 : " + strr);

        String str4 = "Hello World";
        System.out.println("indexOf결과: " + str4.indexOf("o", 5));


//3. 특정단어(부분)만 자르기
        String str5 = "바나나 : 1000원, 사과 : 2000원, 배 : 3000원";
        String target = "사과";
        int target_num = str5.indexOf(target);
        String result; result = str5.substring(target_num,(str5.substring(target_num).indexOf("원")+target_num));
        System.out.println(result+"원");
//결과값 : 사과 : 2000원
    }
}
