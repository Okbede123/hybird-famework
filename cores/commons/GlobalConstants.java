package src2.cores.commons;

public class GlobalConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");

    public static final String USER_URL = "http://live.techpanda.org/index.php/";

    public static final String ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";

    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";

    public static final int SHORT_TIMEOUT = 10;
    public static final int LONG_TIMEOUT = 30;

    public static final String UPLOAD_PATH = PROJECT_PATH + "\\out\\" + "\\UpLoadFiles";

    public static void main(String[] args) {
        System.out.println(UPLOAD_PATH);
    }
}
