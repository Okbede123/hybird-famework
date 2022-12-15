import org.testng.annotations.Test;

public class SuDungTest {

    @Test(priority = 2)
   void Result(){

        System.out.println("so1");
    }

    @Test(priority = 1)
    void Result2(){
        System.out.println("so2");
    }
}
