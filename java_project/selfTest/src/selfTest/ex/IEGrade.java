package selfTest.ex;

public class IEGrade {
	public static void main(String[] args) {
		
		int score = 83;
		
		String grade = "";// A+, A, A-, B+, B, B-, C
		
		if(score>=90) {
			grade = "A";
			if(score>=98) {
				grade = grade + "+";
			} else if(score<94) { // 90이상
				grade += "-";
			}
		}
		else if(score >= 80) {
			grade = "B";
		} else if(score >= 88) {
			grade += "+";
		} else if(score < 84) {
			grade += "-";
		}
		System.out.println(grade);
		
		//100~98:A+, 97~94:A, 93~90:A-
//		if(score>98 && score<=100) {
//			grade="A+";
//		}
//		if(score>94 && score<=97) {
//			grade="A";
//		}
//		if(score>93 && score<=90) {
//			grade="A-";
//		}
		
		
	}
}
