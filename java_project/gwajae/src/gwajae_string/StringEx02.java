package gwajae_string;

public class StringEx02 {
    public static void main(String[] args) {

        String str = "990929-1010123";
        char value = ' ';
        for(int i=0; i<str.length(); i++){
            value = str.charAt(i);
            if((value >= '0' ) && (value <= '9')){
                System.out.print(str.charAt(i));
            }
        }

    }
}
