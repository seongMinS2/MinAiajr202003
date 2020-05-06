package ex;

public class ThreadMain8 {

    public static void main(String[] args) {

        Calcurator cal = new Calcurator();

        CalThreaed cat = new CalThreaed(cal);
        CalThreaed cmt = new CalThreaed(cal);

        cat.start();
        cmt.start();

        try {
            cat.join();
            cmt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cal.showOpCnt();
    }
}
