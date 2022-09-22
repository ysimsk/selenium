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
import java.util.Collection;
import java.util.List;

public class herokudropdown {
  /*  Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın
   */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
@Test
    public void test1() throws InterruptedException {
    WebElement button= driver.findElement(By.xpath("//*[@id='dropdown']"));
    Select select=new Select(button);
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    select.selectByIndex(1);
  //  System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    select.selectByIndex(2);
   // System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    select.selectByVisibleText("Option 1");
   // System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
   List<WebElement> yagipp= select.getAllSelectedOptions();
    for (WebElement y:yagipp
         ) {
        System.out.println("y.getText() = " + y.getText());
    }
    //4.Tüm dropdown değerleri(value) yazdırın

    List<WebElement> src=select.getOptions();
    for (WebElement w:src
         ) {
        System.out.println("w.getText() = " + w.getText());
    }

    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    //False yazdırın
    System.out.println("select.getOptions().size() = " + select.getOptions().size());
    System.out.println(select.getOptions().size()==3);

}
}
