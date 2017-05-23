package e2eTestFramework.pages;

import e2eTestFramework.common.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideSliderHeader extends PageObject {

    public static final String SIDE_SLIDER_HEADER= "header.c-srp-slider__header";
    public static final String DETAIL_BUTTON= "callout-snippet-more-info-link";

    @FindBy (xpath = SIDE_SLIDER_HEADER)
    @CacheLookup
    private WebElement sideSliderHeader;

    @FindBy (css = DETAIL_BUTTON)
    @CacheLookup
    private WebElement parkingSpaceDetail;

    public static WebDriverWait getWebDriverWaitForSideSlider(WebDriver driver) {
        // WAIT until slider loads After Selecting A Parking Space
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector((SIDE_SLIDER_HEADER))));
        return wait;
    }

    public static void openDetailsOfParkingSpace(WebDriver driver, WebDriverWait wait) {
        // ParkingSpace.DetailsButton
        WebElement detailsButton = driver.findElement(By.id(DETAIL_BUTTON));
        detailsButton.click();
    }

    public SideSliderHeader(WebDriver driver, String pageTitle) {
        super(driver, pageTitle);
    }

}
