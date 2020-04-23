package car01;

public class CarMain {
    public static void main(String[] args) {
        HybridWaterCar hCar = new HybridWaterCar(3, 5,7);

        hCar.showCurrentGauge();
        System.out.println(hCar.gasolinegauge += 10);
        System.out.println(hCar.waterGauge += 10);
        System.out.println(hCar.electronicGauge += 10);

        hCar.showCurrentGauge();

    }
}
