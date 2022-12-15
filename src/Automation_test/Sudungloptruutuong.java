public class Sudungloptruutuong extends LopTruuTuong {

    @Override
    public void hienthi() {
        System.out.println("meo");
    }

    public void GetNameTest(){
        String t = "okbede";
        System.out.println(t);
    }


    public static void main(String[] args) {
        Sudungloptruutuong khoitao = new Sudungloptruutuong();
        khoitao.hienthi();
        khoitao.GetNameTest();
    }

}
