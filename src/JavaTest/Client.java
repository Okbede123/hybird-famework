package JavaTest;

public class Client {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
       Car car = carFactory.getTypeCar(CarType.HONDA);
       car.viewCar();
       car.driverCar();

       Honda honda = new Honda();
       honda.boostSpeed();
    }
}
