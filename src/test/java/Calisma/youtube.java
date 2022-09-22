package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class youtube {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    WebDriver driver;
@Before
    public  void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    driver.get("https://www.youtube.com");
}
@After
    public void teardown(){
    driver.close();
}



@Test
    public void test2(){
    WebElement button= driver.findElement(By.xpath("(//tp-yt-paper-button[@id='button'])[7]"));
    button.click();
    WebElement ayar1=driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[7]"));
    ayar1.click();

    //* titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    String expectedbaslik="Youtube";
    String actualbaslik= driver.getTitle();
    Assert.assertNotEquals(expectedbaslik,actualbaslik);

    //* imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    WebElement sayfabasligi= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
    System.out.println("sayfabasligi.isDisplayed() = " + sayfabasligi.isDisplayed());
    // * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    WebElement searchbox=driver.findElement(By.xpath("//input[@id='search']"));
    System.out.println("searchbox.isEnabled() = " + searchbox.isEnabled());
}





}
