package Day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C01Actions {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test1()  {
        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        // poduct bolumune gecelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk urunu secelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.cssSelector("img[alt=\"ecommerce website products\"]")).click();

    }
}