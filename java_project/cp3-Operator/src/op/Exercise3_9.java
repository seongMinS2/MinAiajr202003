package op;

public class Exercise3_9 {

	public static void main(String[] args) {
		char ch = 'C';

		boolean b = ('a' <= ch | 'z' >= ch && 'A' <= ch | 'Z' >= ch) ? true : false;
		//boolean b = ((ch>='a')&&(ch<='z')||(ch>='A')&&(ch<='Z')||(int)ch>=0);
		System.out.println(b);
	}

}
