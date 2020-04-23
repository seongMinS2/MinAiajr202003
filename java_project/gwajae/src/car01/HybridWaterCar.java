package car01;

public class HybridWaterCar extends  HybridCar {
    int waterGauge;

    HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
        super(gasolinegauge,electronicGauge);
        this.waterGauge = waterGauge;
    }

    public void showCurrentGauge(){
        System.out.println("잔여 가솔린: " + gasolinegauge);
        System.out.println("잔여 가솔린: " + electronicGauge);
        System.out.println("잔여 가솔린: " + waterGauge);
    }
}
