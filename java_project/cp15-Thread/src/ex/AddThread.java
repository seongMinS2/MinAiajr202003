package ex;

public class AddThread extends Thread {

    Sum sumInst;
    long start;
    long end;

    AddThread(Sum sum, long s, long e){
        this.sumInst = sum;
        this.start = s;
        this.end = e;
    }

    @Override
    public void run() {
        for(long i=start; i<end; i++){
         sumInst.addNum(i);
        }
    }
}
