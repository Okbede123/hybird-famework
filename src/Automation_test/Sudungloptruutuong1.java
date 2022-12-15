public class Sudungloptruutuong1 extends LopTruuTuong {
    @Override
    public void hienthi() {

    }
    String ten = name;

    public String SetName(String a){
        ten = a;
        return a;
    }

    public static void main(String[] args) {
        Sudungloptruutuong khoitao = new Sudungloptruutuong();
        String a = khoitao.SetName("ok");
        System.out.println(a);
    }
}
