package src2.interrface.UI.AdminUI;

public class AdminBasePageUI {

    public static final String LOG_OUT_LOCATOR = "xpath=//a[text() = 'Log Out']";

    public static final String DYNAMIC_TEXTBOX_BY_ID ="xpath=//input[@id ='%s']";

    public static final String DYNAMIC_BUTTON_TITLE ="xpath=//*[@title='%s']";

    public static final String DYNAMIC_FIELD_ERROR_MESSAGE_BY_ID ="xpath=//div[@id='%s']";

    public static final String PAGE_ERROR_MESSAGE ="xpath=//li[@class='error-msg']//span";
    public static final String PAGE_SUCCESS_MESSAGE ="xpath=//li[@class='success-msg']//span";

    public static final String DYNAMIC_DROPDOWN_BY_ID ="xpath=//select[@id='%s']";
}
