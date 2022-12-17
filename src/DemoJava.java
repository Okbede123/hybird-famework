public class DemoJava {

    String tuoi;
    int ten;

    public String getTuoi(){
        return tuoi;
    }

    public void setTuoi(String tuoi){
        this.tuoi = tuoi;
    }

    public int getTen(){
        return ten;
    }

    public void setHoten(String hoten){

    }

    public void setTen(int ten){
        this.ten = ten;
    }

    public static void main(String[] args) {
        DemoExtend demoExtend = new DemoExtend();
        System.out.println(demoExtend.hoten);
        System.out.println(demoExtend.queQuan);
    }
}
