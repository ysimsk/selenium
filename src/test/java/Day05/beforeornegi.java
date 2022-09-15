package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class beforeornegi {
     /*
      1. Bir class oluşturun : CheckBoxTest
      2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
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
        driver.get("https://the-internet.herokuapp.com/checkboxes");

     WebElement checkbox1= driver.findElement(By.xpath("//*[@id='checkboxes']"));
   WebElement cehckbox2=driver.findElement(By.xpath("//*[@type='checkbox'][1]"));

   if (!checkbox1.isSelected()){
   checkbox1.click();}

   if(!cehckbox2.isSelected()){
       cehckbox2.click();
   }

    }

    @After
    public void teardown(){
        driver.close();
    }
}
