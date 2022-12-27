package src2.interrface.UI.JqueryPageUI;

public class HomePageUIJquery {

    public static final String DYNAMIC_LOCATOR_HEADER = "xpath=//div[text() = '%s']//parent::div//following-sibling::input";

    public static final String DYNAMIC_VERIFY_HEADER = "xpath=//td[@data-key = 'females' and text() = '%s']//following-sibling::td[@data-key = 'country' and text() = '%s']//following-sibling::td[@data-key = 'males' and text() = '%s']//following-sibling::td[@data-key = 'total' and text() = '%s']";

    public static final String DYNAMIC_REMOVE_EDIT_HEADER = "xpath=//td[@data-key = 'country' and text() = '%s']//preceding-sibling::td/button[contains(@class,'%s')]";

    public static final String DYNAMIC_NUMBER_PAGE = "xpath=//a[text() = '%s']";

    public static final String DYNAMIC_VERIFY_NUMBER_PAGE = "xpath=//a[contains(@class,'active') and text() = '%s']";

    public static final String DYNAMIC_NAME_COLUM = "xpath=//th[text() = '%s']//parent::tr//parent::thead//following-sibling::tbody/tr[%s]/td[%s]/input";

    public static final String COUNTRY_SELECT_NAME = "xpath=//th[text() = 'Country']//parent::tr//parent::thead//following-sibling::tbody//tr[%s]//td/div/select";

    //th[text() = 'Contact Person']//parent::tr//parent::thead//following-sibling::tbody/tr[1]/td[3]

    public static final String DYNAMIC_NAME_COLUM_GET_INDEX = "xpath=//th[text() = '%s']//preceding-sibling::*";

    public static final String ROW_INDEX = "xpath=//tr[%s]//td[%s]/input";

    public static final String UPLOAD_BUTTON = "xpath=//span[text() = 'Start']";

    public static final String IMAGE_UPLOAD_SUCCESS = "xpath=//p[@class = 'name']/a[text() = '%s']";
}
