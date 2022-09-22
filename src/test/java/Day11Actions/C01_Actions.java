package Day11Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class C01_Actions {
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
        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        // action classini kullanarak A71 aratalim
        Actions actions=new Actions(driver);
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchbox).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT)
                .sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
      //aramanin gerceklestigini test edelim
        WebElement sonuc=driver.findElement(By.xpath("//*[text()='\"samsung A71\"']"));
        Assert.assertTrue(sonuc.isDisplayed());

    }
}
