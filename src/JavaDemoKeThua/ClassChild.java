package JavaDemoKeThua;

public class ClassChild extends ClassParent {

    public void getChild(){
        System.out.println("day la thang con");
    }

    public static void main(String[] args) {
        ClassChild classChild = new ClassChild();
        classChild.getParent();
        classChild.getOng();
    }
}
