package main;

public class Student {

    private int num1;
    int num2;

//    public void setNum1(int num1) {
//        this.num1 = num1;
//    }
//
//    public int getNum1(){
//        return num1;
//    }

    String str;

    Student(){
    }

    Student(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    Student(int num1, int num2, String str){
        this.num1 = num1;
        this.num2 = num2;
        this.str = str;
    }

 static void add(int num1, int num2){
     System.out.println(num1 + num2);
 }

}
