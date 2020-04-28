package ex;

public class AbstractInterfaceMain {
    public static void main(String[] args) {

        //PersonalNumberStorage storage = new PersnalNumberStorageImpl(100);

        PersnalNumber pn = new PersnalNumberStorageImpl(100);

        pn.addPersnalInfo("202020-1111111", "손흥민");
        pn.addPersnalInfo("201010-1000000", "박지성");

        System.out.println(pn.searchName("202020-1111111"));
        System.out.println(pn.searchName("201010-1000000"));
    }
}
