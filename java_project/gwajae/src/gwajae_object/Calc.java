package gwajae_object;

public class Calc {
    int remainder = 0;

    public int add(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }

    public int multi(int a, int b){
        return a*b;
    }

    public int div(int a, int b){

        remainder = a%b;

        return a/b;
    }
}
