package JavaTest;

public class Honda implements Car,Upgrade_Car {
    @Override
    public void viewCar() {
        System.out.println("view Honda");
    }

    @Override
    public void driverCar() {
        System.out.println("drive Honda");
    }

    @Override
    public int boostSpeed() {
        return 10;
    }
}
