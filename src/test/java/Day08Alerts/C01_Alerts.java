package Day08Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    /*

// Click for JS Alert butonuna tıklayalım
// Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
  */

WebDriver driver;
@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));

}
@Test
    public void test1(){
    //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
    driver.get("http://webdriveruniversity.com/IFrame/index.html");
    //Our Products" butonuna basin
    WebElement iframe= driver.findElement(By.xpath("//iframe"));
    driver.switchTo().frame(iframe);
    driver.findElement(By.xpath("//*[text()='Our Products']")).click();

    //Cameras product"i tiklayin
    driver.findElement(By.id("camera-img")).click();

    // Popup mesajini yazdirin
    //WebElement yazi=driver.findElement(By.xpath("//*[@class='modal-header']"));
   // System.out.println(yazi.getText());
 // System.out.println("yazi"+driver.findElement(By.xpath("//*[@class='modal-title']")).getText());

    //close" butonuna basin
//WebdriverUniversity.com (IFrame)" linkini tiklayin
//http://webdriveruniversity.com/index.html" adresine gittigini test edin


}
}
