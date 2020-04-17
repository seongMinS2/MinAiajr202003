package api;

public class StringTest {
    public static void main(String[] args) {

        String str1 = "My String";
        String str2 = "My String";
        String str3 = "Your String";

        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1.equals(str2));

        //문자열을 붙여줌
        System.out.println(str1.concat(str2).concat(str3));


        System.out.println("------------------");


        String str = "My name is JAVA";

        int strLength = str.length();
        System.out.println("문자열 str의 문자열의 길이는: " + strLength);

        int strLength2 = "한글의 길이는? ".length();
        System.out.println("문자열 str의 문자열의 길이는: " + strLength2);

        for(int i=0; i<str.length(); i++){
            System.out.println(i + "번째 단어: " + str.charAt(i));
        }
    }
}
