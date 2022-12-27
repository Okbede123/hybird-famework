package JavaTest;

public class Huyndai implements Car,Upgrade_Car{
    @Override
    public void viewCar() {
        System.out.println("view Hyundai");
    }

    @Override
    public void driverCar() {
        System.out.println("drive Hyundai");
    }

    @Override
    public int boostSpeed() {
        return 20;
    }
}
