package JavaTest.DemoFormatString;

public class DemoStringFormat {

    public static void main(String[] args) {

        setDayMonthYears("hom nay la thu %s ngay %s nam %s","2","23","2012");
    }

    public static void setDayMonthYears(String value1, String...values2){
        value1 = String.format(value1, (Object[]) values2);
        System.out.println(value1);
    }
}
