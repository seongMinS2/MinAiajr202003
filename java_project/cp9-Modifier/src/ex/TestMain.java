package ex;

public class TestMain {
    public static void main(String[] args) {

        Singleton.getInstance().print();



        Member member = new Member();

        System.out.println(member.getName());

    }
}
