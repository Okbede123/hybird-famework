package JavaTest;

public class CarFactoryAbtract {
    public CarAbtract wakeUpCar(CarType carType){
        switch (carType){
            case HONDA:{
                return new HondaAbtract();
            }
            case HUYNDAI:{
                return new HuyndaiAbtract();
            }
            default:{
                throw new RuntimeException("khong co xe nao");
            }
        }
    }
}
