package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class webuniverstyactions_onemli_ {
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
        //driver.close();
    }
    @Test
    public void test1(){
       // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
       // "Hover over Me First" kutusunun ustune gelin
      WebElement target=driver.findElement(By.xpath("//*[text()='Hover Over Me Third!']"));
        // "Link 1" e tiklayin
        Actions actions=new Actions(driver);
        actions.moveToElement(target).perform();
        driver.findElement(By.xpath("(//*[text()='Link 1'])[3]")).click();
       // Popup mesajini yazdirin
        System.out.println("Pop mesaji = " + driver.switchTo().alert().getText());
        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
       // "Click and hold" kutusuna basili tutun
        WebElement hedef= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(hedef).perform();
       // "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("yazi1 = " + hedef.getText());
        // "Double click me" butonunu cift tiklayin
        WebElement hedef2=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(hedef2).perform();
    }
}
