import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class UberEatsTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();


        driver.get("https://www.ubereats.com/fr");
        driver.manage().window().maximize();
        //fermer cookies
        WebElement buttonCookies = driver.findElement(new By.ByCssSelector(".bc.gh.gi.gl.bj.bk.bl.bm.bn.bo.bt.bu.ba.bb"));
        buttonCookies.click();

    }
     @AfterMethod
    public void teardown (){
        driver.quit();
    }


    @Test
    public void addBurgerToCart() {

        //chercher Adresse la Defense

        WebElement barreRecherche = driver.findElement(By.id("location-typeahead-home-input"));
        barreRecherche.sendKeys("la defense");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        barreRecherche.sendKeys(Keys.ENTER);

        // selectionner la categorie burger

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectBurger = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='Burgers']")));

        // selectionner le restaurant King Marcel

        WebElement listBurger = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3")));
        listBurger.click();

         // selectionner le premier burger

        WebElement selectproduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                cssSelector("div[tabindex='0']")));
        selectproduct.click();

        // ajouter le premier burger au panier

        WebElement addtocart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                cssSelector(".spacer._24 + button.b8")));
        addtocart.click();

        // attendre invisibility
        By addToCartButtonSelector =  By.cssSelector(".spacer._24 + button.b8");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToCartButtonSelector));

        By selectorCheckItemInPanier = By.cssSelector("button[aria-label='checkout'] > div");
        String expectedCartItems = "1";

// Assert
        WebElement cart = driver.findElement(selectorCheckItemInPanier);
        Assert.assertTrue(cart.getText().contains(expectedCartItems), "The cart does not contain 1 item");



    }



}
