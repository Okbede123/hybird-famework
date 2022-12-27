package JavaTest;

public class HuyndaiAbtract extends CarAbtract{
    @Override
    void viewCar() {
        System.out.println("huyendai car");
    }

    @Override
    String getNameCar() {
        return "huyndai";
    }

    @Override
    public void fixcar() {
        System.out.println("fix xe xong huyndai");
        System.out.println("fix xe xong  huyndai 2");
    }

    @Override
    int boostSpeed() {
        return 30;
    }

    @Override
    String setColorCar() {
        return "vàng huyndai";
    }

    @Override
    public void setUpgradeCar() {
        int heigt = 5;
        System.out.println(heigt);
    }
}
