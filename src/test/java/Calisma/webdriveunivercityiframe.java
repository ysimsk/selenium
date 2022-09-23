package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webdriveunivercityiframe {

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
    public void test1(){
        // "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //"Our Products" butonuna basin
        WebElement frame= driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        //"Cameras product"i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        //Popup mesajini yazdirin
        System.out.println("Popup mesaj = " + driver.findElement(By.xpath("//p")).getText());
        //"close" butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//*[@id='nav-title'])[1]")).click();
        // istersek burada assert ile oraya tikladigimizi kanitlayabiliriz

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }

}
