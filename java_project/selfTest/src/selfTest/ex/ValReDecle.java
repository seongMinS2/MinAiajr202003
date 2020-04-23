package selfTest.ex;

public class ValReDecle {
    public static void main(String[] args) {

        CCC ref1 = new CCC();
        BBB ref2 = ref1;
        AAA ref3 = ref2;
        System.out.println("CCC's ref: " + ref1.num);
        System.out.println("BBB's ref: " + ref2.num);
        System.out.println("AAA's ref: " + ref3.num);


    }
}
