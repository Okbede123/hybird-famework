public class Sapxepthutumang {
    public static void main(String[] args) {
        int [] dayso = {2,7,3,12,4};
        int temp;
        for (int i = 0; i < dayso.length ; i++) {

            for (int j = i + 1; j < dayso.length; j++) {
                if(dayso[i] < dayso[j]){ //8 > 3
                    temp = dayso[j]; // temp = 3
                    dayso[j] = dayso[i]; // j = 8
                    //temp = dayso[i];
                    dayso[i] = temp;  // i = 3
                }
            }
            System.out.println(dayso[i]);
        }
    }
}
