package e2eTestFramework.pages;

import e2eTestFramework.common.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class Search extends PageObject{

    public static final String BASE_URL="https://www.justpark.com/uk/parking/";

    public static final String LOCATION_SEARCH_FIELD = "id_q";
    public static final String START_DATE_FIELD = "id_start_date";
    public static final String END_DATE_FIELD = "id_end_date";
    public static final String START_TIME_FIELD = "id_start_time";
    public static final String END_TIME_FIELD = "id_end_time";
    public static final String SEARCH_BUTTON = ".o-field__input.c-srp-form__submit-search";

    public static final String ITEMA = "A";
    public static final String ITEMB = "B";
    public static final String ITEMC = "C";

    public static final String LIST_ITEM_A_LOCATION = "html/body/main/div/div[1]/div[1]/div[2]/a[1]/article/div[1]";
    public static final String LIST_ITEM_B_LOCATION = "html/body/main/div/div[1]/div[1]/div[2]/a[2]/article/div[1]";
    public static final String LIST_ITEM_C_LOCATION = "html/body/main/div/div[1]/div[1]/div[2]/a[3]/article/div[1]";

    @FindBy(id = LOCATION_SEARCH_FIELD)
    @CacheLookup
    private WebElement locationInputField;

    @FindBy (id = START_DATE_FIELD)
    @CacheLookup
    private WebElement startDate;

    @FindBy (id = END_DATE_FIELD)
    @CacheLookup
    private WebElement endDate;

    @FindBy (id = START_TIME_FIELD)
    @CacheLookup
    private WebElement startTime;

    @FindBy (id = END_TIME_FIELD)
    @CacheLookup
    private WebElement endTime;

    @FindBy (css = SEARCH_BUTTON)
    @CacheLookup
    private WebElement searchButton;



    public Search(WebDriver driver) {
        super(driver);   }


    public static void goToCitySearchResults(String cityName, WebDriver driver) {
        // SEARCH FOR PARKING SPACE IN A GIVEN LOCATION
        driver.get(BASE_URL + cityName);
        System.out.println("Successfully opened the search results for : " + BASE_URL + cityName);
    }


    public static void clickOnAvailableParkingSpace(String xPathLocation, WebDriver driver) {
        // Search Result Item
        WebElement parkingSpaceLink = driver.findElement(By.xpath(xPathLocation));
        parkingSpaceLink.click();
    }


}
