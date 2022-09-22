package Day09windowhandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02Windowhandle {

    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
    @After
    public void teardown(){
       // driver.quit();
    }
    @Test
    public void test1(){

//1-Yeni bir class olusturun: WindowHandle
//2-Amazon anasayfa adresine gidin.
driver.get("https://www.amazon.com");

//3-Sayfa'nin window handle degerini String bir degiskene atayin
        String amazonHandle= driver.getWindowHandle();

//4-Sayfa title'nin "Amazon" icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//5-Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
      driver.switchTo().newWindow(WindowType.TAB);
      driver.get("https://www.techproeducation.com");

//6-Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));

//7-Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

//8-Sayfa title'nin "Walmart" icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));

//9-Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
driver.switchTo().window(amazonHandle);
Assert.assertTrue(driver.getTitle().contains(actualTitle));


    }
}
