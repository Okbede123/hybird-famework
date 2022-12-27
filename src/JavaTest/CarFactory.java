package JavaTest;

public class CarFactory {
    public  Car getTypeCar(CarType carType){
        switch (carType){
            case HONDA:{
                return new Honda();
            }
            case MAZDA:{
                return new Mazda();
            }
            case HUYNDAI:{
                return new Huyndai();
            }
            default:{
                throw new RuntimeException("wrong car");
            }
        }
    }
}
