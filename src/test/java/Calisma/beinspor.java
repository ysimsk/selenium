package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class beinspor {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("https://www.beinsports.com.tr/");
    }
    @AfterClass
    public static void teardown() {

       // driver.close();
    }
    @Test
    public void test1(){
        WebElement drop= driver.findElement(By.xpath("(//*[@class='d-flex align-items-center justify-content-between px-4 py-3'])[1]"));
drop.click();
        /*
        Select select=new Select(drop);
        select.selectByIndex(2);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

   // drop.sendKeys("Spor Toto 1.Lig");

 */



    }

}
