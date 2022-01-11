import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    By addToCartButtonSelector = By.id("add-to-cart-button");
    By addWarrantyButtonSelector = By.cssSelector("#attachSiAddCoverage input");
    int timeoutSearch = 3;
    int timeoutConfirmation = 10;
    By noCoverageButtonSelector = By.cssSelector("#attachSiNoCoverage input");
    By confiramtionImageSelector = By.id("add-to-cart-confirmation-image");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(addToCartButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearch));
        wait.until(ExpectedConditions.elementToBeClickable(addWarrantyButtonSelector));

    }

    public void noConverge(){
        driver.findElement(noCoverageButtonSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutConfirmation));
        wait.until(ExpectedConditions.elementToBeClickable(confiramtionImageSelector));

    }
}