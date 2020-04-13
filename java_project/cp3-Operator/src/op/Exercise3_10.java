package op;

public class Exercise3_10 {

	public static void main(String[] args) {

		char ch = 'B';
		
		char lowerCase =(char)((ch >= 65) && (ch <= 90) ? ch+32 : ch);
		
		System.out.println("ch:"+ch);
		
		System.out.println("chto lowerCase:"+lowerCase);
	}

}
