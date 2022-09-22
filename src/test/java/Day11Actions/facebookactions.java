package Day11Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class facebookactions {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test1() {
        driver.get("https://www.facebook.com");
        Actions actions=new Actions(driver);
        WebElement isim =driver.findElement(By.xpath("//input[@name='firstname']"));
        isim.sendKeys("Osbt");
        actions.sendKeys(Keys.TAB).
                sendKeys("Cimbom").
                sendKeys(Keys.TAB).
                sendKeys("osbt@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("osbt@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Oca").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();
    }
}
