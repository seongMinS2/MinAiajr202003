package ex;

public class CalThreaed extends Thread {

    Calcurator cal;

    public CalThreaed(Calcurator cal) {
        this.cal = cal;
    }

    @Override
    public void run() {
        System.out.println(cal.add(1,2));

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cal.add(2,4));

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
