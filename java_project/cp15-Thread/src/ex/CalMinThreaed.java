package ex;

public class CalMinThreaed extends Thread {

    Calcurator cal;

    public CalMinThreaed(Calcurator cal) {
        this.cal = cal;
    }

    @Override
    public void run() {
        System.out.println(cal.min(2,1));

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cal.min(4,2));

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
