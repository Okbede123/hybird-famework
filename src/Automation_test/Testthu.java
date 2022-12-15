public class Testthu {
    int rollno;
    String name;
    String college = "Bưu Chính Viễn Thông";

    Testthu(int r, String n) {
        rollno = r;
        name = n;
    }

    void display() {
        System.out.println(rollno + " - " + name + " - " + college);
    }

    public static void main(String args[]) {
        Testthu s1 = new Testthu(111, "Thông");
        Testthu s2 = new Testthu(222, "Minh");

        s1.display();
        s2.display();
    }
}
