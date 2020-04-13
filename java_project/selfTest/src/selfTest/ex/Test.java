package selfTest.ex;

public class Test {

	static void display(int num1) { System.out.println(num1); }

	static void display(int num1, int num2) { System.out.println(num1 * num2); }

    static void display(int num1, double num2) { System.out.println(num1 + num2); }
	
	 private int count(int idx) {
	        
		 System.out.println("idx:"+idx);
	        
	        if(idx == 0) 
	        	return 0;
	        
	        return count(idx -1);
	    }
	 
	    public void run() {
	     
	    	int result = count(10);
	        
	    	System.out.println("result:"+result);
	    }
	 
	    public static void main(String[] args) {
	        new Test().run();
	    }
}
