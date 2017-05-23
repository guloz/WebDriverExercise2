package e2eTestFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ParkingSpace {
    public static final String SUBTOTAL_CALCULATION=".subtotal-calculation";

    public static void checkParkingSpaceIsAvailable(WebDriver driver, WebDriverWait wait) {
        //PARKING SPACE PAGE - WAIT for COST calculation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector((SUBTOTAL_CALCULATION))));
        WebElement costCalculator = driver.findElement(By.cssSelector(SUBTOTAL_CALCULATION));
        System.out.print("Total Value is :" + costCalculator.getText());  }
}
