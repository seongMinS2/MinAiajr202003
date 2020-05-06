package ex;

public class AdderThreaed extends Sum implements Runnable {

    int start, end;

    //int num;
    //addNum, getNum

    public AdderThreaed(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i=start; i<=end; i++){
            addNum(i);
        }
    }
}
