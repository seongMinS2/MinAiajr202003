package ex;

public class BaseEnSpeaker extends Speaker {

    private int baseRate;

    public void showCurrentState(){
        super.showCurrentState();
        System.out.println("베이스 크기: " + baseRate);
    }


    public void setBaseRate(int base){
        baseRate = base;
    }

}
