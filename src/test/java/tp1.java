import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

        //implicit wait 2 secondes ici
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        //fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();

    }
    @AfterMethod
    public void teardown (){
        driver.quit();
    }

    //chercher machine a raclette
    @Test
    public void test1() {

        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);


    }

    @Test
    public void test2() {


        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);

        //implicit wait ici

        WebElement selectproduct = driver.findElement(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-11]"));
        selectproduct.click();
        WebElement buttonAjouterAuPanier = driver.findElement(By.cssSelector("# add-to-cart-button"));
        buttonAjouterAuPanier.click();


    }
}
