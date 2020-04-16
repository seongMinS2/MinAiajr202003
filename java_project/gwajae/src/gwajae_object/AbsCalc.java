package gwajae_object;

public class AbsCalc {
    int remainder = 0;

    public int add(int a, int b){
        return Math.abs(a+b);
    }

    public int sub(int a, int b){
        return Math.abs(a-b);
    }

    public int multi(int a, int b){
        return Math.abs(a*b);
    }

    public int div(int a, int b){

        remainder = Math.abs(a%b);

        return Math.abs(a/b);
    }
}
