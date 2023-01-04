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

    public static final String UPLOAD_PATH = PROJECT_PATH + "\\out\\" + "\\UpLoadFiles\\";

    public static final String UPLOAD_LOCATOR = "xpath=//input[@type = 'file']";

    //retry case failed
    public static final int RETRY_NUMBER = 2;

    //browser log
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + "\\out\\" + "\\browserLogs";
    public static final String BROWSER_EXTENTSION_PATH = PROJECT_PATH + "\\out\\" + "\\browserExtension";

    //html report folder

    public static final String REPORTNG_PATH = PROJECT_PATH + "\\out\\" + "\\reportNGScreenshot\\";
    public static final String EXTENT_PATH = PROJECT_PATH + "\\out\\" + "\\htmlExtent";
    public static final String ALLURE_PATH = PROJECT_PATH + "\\out\\" + "\\htmlAllure";

    public static final String JAVA_VERSION = System.getProperty("java.version");
}
