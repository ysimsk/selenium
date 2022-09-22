package Day08Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02Alerts {
    /*
    Bir class olusturun: Alerts
 Bir metod olusturun: dismissAlert

    Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("ttps://the-internet.herokuapp.com/javascript_alerts");
        // 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        // You successfully clicked an alert” oldugunu test edin.
     WebElement text= driver.findElement(By.id("//*[@id='result']"));
     String actualtext=text.getText();
     String expectedtext="You successfully clicked an alert";
        Assert.assertEquals(actualtext,expectedtext);

    }
@Test
public void test2(){
   driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}

}
