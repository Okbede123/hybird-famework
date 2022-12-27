package JavaTest;

public class DemoBaiTap1 {

    public static void main(String[] args) {
        int a = 5;
        int b = 6;

        a = a + b; // a = 11
        b = a - b; // 11 - 6 -> b = 5
        a = a - b;//11-5 -> a = 6

        System.out.println(a);
        System.out.println(b);
    }
}
