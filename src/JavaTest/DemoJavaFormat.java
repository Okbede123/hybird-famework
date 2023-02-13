package JavaTest;

public class DemoJavaFormat {



    public static void main(String[] args) {
        String name="sonoo";
        String name1 = "123";
        String sf1=String.format("name is %s",name1);

        String t = "//span[text() = '123'";

        String tx = "123";
        String sf2 = String.format("//tr[text() %s",tx);
        System.out.println(sf2);
    }
}
