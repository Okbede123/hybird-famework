package src2.interrface.UI;

public class SideBarPageUI {

    //dufng chung cho cac page

    //mỗi page có locator duy nhất

    public static final String MY_ORDER_PAGE_LOCATOR = "//li/a[text() = 'My Orders']";
    public static final String MY_APPLICATION_LOCATOR = "//li/a[text() = 'My Applications']";
    public static final String PRODUCT_REVIEW_LOCATOR = "//li/a[text() = 'My Product Reviews']";
    public static final String  ACCOUNT_INFORMATION = "//li/a[text() = 'Account Information']";

    public static final String  MY_DASHBOARD = "//li/a[text() = 'Account Dashboard']";

    public static final String LOGIN_MYDASHBOARD = "//button[@id = 'send2']";

    public static final String MY_ACCOUT_LOCATOR = "//a[@class = 'skip-link skip-account']//span[text() = 'Account']";

    public static final String LOG_OUT_LOCATOR = "//li/a[text() = 'Log Out']";

    public static final String ADDRESS_LINK_LOCATOR = "xpath=//li/a[text() = 'My Applications']";

    public static final String BILLING_AGREEMENT_LOCATOR = "xpath=//li/a[text() = 'Billing Agreements']";

    public static final String DYNAMIC_SIDEBAR_LOCATOR = "xpath=//li/a[text() = '%s']";

}
