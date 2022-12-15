import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoMap {
    public static void main(String[] args) {
        ArrayList<Integer> so1 = new ArrayList<>();
        so1.add(5);
        so1.add(8);

        Map<Integer,String> demoMap = new HashMap<>();

//        for (int i = 0; i < so1.size(); i++) {
//            System.out.println(so1.get(i));
//        }
        for(int test : so1){

            demoMap.put(test,"day la so");

            for(Integer so : demoMap.keySet()){
                String giaTri = demoMap.get(so);
                System.out.println(test + " " + giaTri);
            }
        }


//        demoMap.put(1,"day la so1");
//        demoMap.put(3,"day la so2");
//        demoMap.put(2,"day la so3");
//        for (Integer so : demoMap.keySet()){
//            String giaTri = demoMap.get(so);
//            System.out.println(giaTri+ " "+so);
//
//        }
//        if(demoMap.containsKey(212)){
//            System.out.println("co key 212");
//        }
    }
}
