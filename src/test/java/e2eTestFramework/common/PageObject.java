package e2eTestFramework.common;

import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ozeli on 15/05/2017.
 */
public class PageObject {


    public static final java.lang.String LONDON= "london";
    public static final java.lang.String LEEDS = "leeds";
    public static final java.lang.String BIRMINGHAM= "birmingham";

    public static final java.lang.String LONDON_RESULTS_PAGE_TITLE = "Parking in London from £11/day | JustPark - The Parking App";
    public static final java.lang.String BIRMINGHAM_RESULTS_PAGE_TITLE = "Parking in Birmingham from £4/day | JustPark";
    public static final java.lang.String LEEDS_RESULTS_PAGE_TITLE = "Parking in Leeds from £5/day | JustPark - The Parking App";

    public static final int TIMEOUT_TEN_SECONDS = 10;
    public static final int POLLING_TIME_IN_MILLISECONDS = 500;

    protected java.lang.String pageTitle;
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        this.pageTitle = driver.getTitle();
    }

    public java.lang.String getPageTitle(){
        java.lang.String title = driver.getTitle();
        return title;
    }

    public boolean verifyBasePageTitle() {
        java.lang.String expectedPageTitle=pageTitle;
        return getPageTitle().contains(expectedPageTitle);
    }

    private Wait<WebDriver> getWebDriverWait(WebDriver driver) {
        return (Wait<WebDriver>) new FluentWait<WebDriver>(driver)
                .withTimeout(TIMEOUT_TEN_SECONDS, TimeUnit.SECONDS)
                .pollingEvery(POLLING_TIME_IN_MILLISECONDS, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class).withMessage("Time out" + TIMEOUT_TEN_SECONDS + "seconds");
    }

    public PageObject(WebDriver driver, String pageTitle){
        this.driver = driver;
        this.pageTitle = driver.getTitle();
        Wait<WebDriver> wait = getWebDriverWait(driver);
        wait.until(ExpectedConditions.titleContains(java.lang.String.valueOf(pageTitle)));

    }

    public PageObject (WebDriver driver, By locator){
        this.driver = driver;
        this.pageTitle = driver.getTitle();
        Wait<WebDriver> wait = getWebDriverWait(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
