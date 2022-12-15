import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LuyenTapMap {
    public static void main(String[] args) {
        ArrayList<Integer> mangSo = new ArrayList<>();
        mangSo.add(7);
        mangSo.add(6);
        mangSo.add(9);
        mangSo.add(7);
        mangSo.add(8);

        //khởi tạo 1 cái map để lưu mấy cái mangsoadd đc vào
        Map<Integer,Integer> getMangSo = new HashMap<Integer,Integer>();

        // check xem số nào trùng thì gán value cho nó làm 2, số nào ko trùng thì gán 1
        for(Integer so1 : mangSo){

            if(getMangSo.containsKey(so1)){
                getMangSo.put(so1,2);
            }
            else{
                getMangSo.put(so1,1);

            }

        }
        // lấy ra tất cả các key của cái getmangSo map, và check xem nếu key nào có value 1 tức là ko trùng thì in ra
        for(Integer so2 : getMangSo.keySet()){
            if(getMangSo.get(so2) == 1){
                System.out.println(so2);
            }
        }

    }
}
