public abstract class LopTruuTuong {

    String name;
    int age;

    public String SetName(String ten){
        name = ten;
        return name;
    }

    public int SetAge(int tuoi){
        return age = tuoi;
    }

    public String GetName(){
        return name;
    }

    public void GetNameTest(){
        //System.out.println("fgsd");
    }

    public abstract void hienthi();


}
