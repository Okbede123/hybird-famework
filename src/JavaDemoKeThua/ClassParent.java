package JavaDemoKeThua;

public class ClassParent extends ClassOng{

    public void getParent(){
        System.out.println("day la thang cha");
    }

    public static void main(String[] args) {
        ClassParent classParent = new ClassParent();
        classParent.getParent();
    }

}
