package JavaTest;

public abstract class CarAbtract extends Upgrade_Car_Abtract {

    abstract void viewCar();

    public void fixcar(){
        System.out.println("sua car");
    }

    abstract String getNameCar();
}
