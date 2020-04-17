package gwajae_string;

public class StringEx01 {
    public static void main(String[] args) {

        String str ="ABCDEFGHIJKLMN";
        char result;

        for(int i= str.length()-1; 0<i; i--) {
           result = str.charAt(i);
            System.out.print(result);
        }

    }
}
