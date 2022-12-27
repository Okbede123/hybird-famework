package JavaTest;

public class ClientAbtract {
    public static void main(String[] args) {
        CarFactoryAbtract carFactoryAbtract = new CarFactoryAbtract();
      CarAbtract carAbtract = carFactoryAbtract.wakeUpCar(CarType.HUYNDAI);

       int speedHonda = carAbtract.boostSpeed();
        System.out.println(speedHonda);
        String colorHuyndai = carAbtract.setColorCar();
        System.out.println(colorHuyndai);
        carAbtract = carFactoryAbtract.wakeUpCar(CarType.HONDA);
        String colorHonda = carAbtract.setColorCar();
        System.out.println(colorHonda);
        System.out.println(carAbtract.boostSpeed());
    }
}
