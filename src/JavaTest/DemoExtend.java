package JavaTest;

public class DemoExtend extends DemoJava {

    String hoten;
    String queQuan;

    public String getHoten(){
        return hoten;
    }

    public void setHoten(String hoten){
        this.hoten = hoten;
    }

    @Override
    public void setTuoi(String tuoi) {
        super.setTuoi(tuoi);
    }


    public static void main(String[] args) {
        DemoJava demoJava = new DemoJava();
        System.out.println(demoJava.ten);
    }
}
