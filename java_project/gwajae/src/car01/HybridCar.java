package car01;

public class HybridCar extends Car {
    int electronicGauge;

    HybridCar(int gaslinegauge, int electronicGauge){
        super(gaslinegauge);
        this.electronicGauge = electronicGauge;
    }
}
