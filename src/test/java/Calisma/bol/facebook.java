package Calisma.bol;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class facebook {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement cerezler= driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']"));
        cerezler.click();
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();
        WebElement secim= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        if(!secim.isSelected()){
            secim.click();
            Thread.sleep(3000);
        }

    }
    @After
    public void teardown(){
        driver.close();
    }
}
