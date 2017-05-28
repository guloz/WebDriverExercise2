package e2eTestFramework.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import e2eTestFramework.common.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static e2eTestFramework.common.PageObject.LONDON;
import static e2eTestFramework.pages.ParkingSpace.checkParkingSpaceIsAvailable;
import static e2eTestFramework.pages.Search.*;
import static e2eTestFramework.pages.SideSliderHeader.getWebDriverWaitForSideSlider;
import static e2eTestFramework.pages.SideSliderHeader.openDetailsOfParkingSpace;
import static org.junit.Assert.assertEquals;


@RunWith(DataProviderRunner.class)
public class Search extends BaseTest{

    @DataProvider
    public static Object[][] exampleLocationsURLs() {
        return new Object[][]{

                {LONDON,        LIST_ITEM_A_LOCATION,    LONDON_RESULTS_PAGE_TITLE},
//                {LONDON,        LIST_ITEM_B_LOCATION,    LONDON_RESULTS_PAGE_TITLE},
//                {LONDON,        LIST_ITEM_C_LOCATION,    LONDON_RESULTS_PAGE_TITLE},
//                {LEEDS,         LIST_ITEM_A_LOCATION,    LEEDS_RESULTS_PAGE_TITLE},
//                {LEEDS,         LIST_ITEM_B_LOCATION,    LEEDS_RESULTS_PAGE_TITLE},
//                {LEEDS,         LIST_ITEM_C_LOCATION,    LEEDS_RESULTS_PAGE_TITLE},
//                {BIRMINGHAM,    LIST_ITEM_A_LOCATION,    BIRMINGHAM_RESULTS_PAGE_TITLE},
//                {BIRMINGHAM,    LIST_ITEM_B_LOCATION,    BIRMINGHAM_RESULTS_PAGE_TITLE},
//                {BIRMINGHAM,    LIST_ITEM_C_LOCATION,    BIRMINGHAM_RESULTS_PAGE_TITLE}
        };
    }

    @Test
    @UseDataProvider("exampleLocationsURLs")
    public void testSearch(String cityName,String xPathLocation, String pageTitle) {


        WebDriver driver;
        System.setProperty(GEKHO_DRIVER, GEKHO_DRIVER_LOCATION);
        driver =new FirefoxDriver();

        goToCitySearchResults(cityName, driver);
        assertEquals(pageTitle, driver.getTitle());
        clickOnAvailableParkingSpace(xPathLocation, driver);
        WebDriverWait wait = getWebDriverWaitForSideSlider(driver);
        openDetailsOfParkingSpace(driver, wait);
        checkParkingSpaceIsAvailable(driver, wait);
        driver.quit();
    }
}
