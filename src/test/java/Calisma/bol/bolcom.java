package Calisma.bol;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class bolcom {

   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bol.com");
    }
    @Test
    public void test1(){
        WebElement button= driver.findElement(By.xpath("//button[@class='ui-btn  ui-btn--primary ui-btn--block@screen-small js-confirm-button']"));
        button.click();
        WebElement searchbox= driver.findElement(By.xpath("//input[@name='searchtext']"));
        searchbox.sendKeys("nutella", Keys.ENTER);
    }
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");

    }
   @AfterClass
    public static void teardown(){
        driver.close();
   }
}
