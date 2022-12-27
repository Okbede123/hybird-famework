package JavaTest.DemoTinhDaHinh;

public class Dog extends DongVat{
    @Override
    public void sua() {
        System.out.println("gau gau");
        System.out.printf("gu gu");
    }

    public static void main(String[] args) {
        DongVat dongVat = new Dog();
        dongVat.sua();
    }
}
