package JavaTest;

public class HondaAbtract extends CarAbtract{
    //phải orverride lại
    @Override
    void viewCar() {
        System.out.println("view honda");
    }

    //phải orverride lại
    @Override
    String getNameCar() {
        return "honda";
    }

    //cho phép override lại hoặc dùng luôn của tk cha
    @Override
    public void fixcar() {
        System.out.println("sua car honda");
    }

    @Override
    int boostSpeed() {
        return 15;
    }

    @Override
    String setColorCar() {
        return "honda đỏ";
    }
}
