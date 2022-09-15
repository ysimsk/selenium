package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class basliklariyazdirma {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
  1- https://www.amazon.com/ sayfasina gidelim
  2- arama kutusunu locate edelim
  3- "Samsung headphones" ile arama yapalim
  4- Bulunan sonuc sayisini yazdiralim
  5- Ilk urunu tiklayalim
  6- Sayfadaki tum basliklari yazdiralim
*/
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        // arama kutusunu locate edelim
        WebElement aramakutus= driver.findElement(By.id("twotabsearchtextbox"));
        //"Samsung headphones" ile arama yapalim
        aramakutus.sendKeys("headphones", Keys.ENTER);

       List<WebElement> basliksayisi=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        System.out.println(basliksayisi.size());
        System.out.println("basliksayisi.get(0) = " + basliksayisi.get(0).getText());

        for (WebElement each:basliksayisi
             ) {

            System.out.println(each.getText());
        }

         // lambda ile
        int sayi=1;

        basliksayisi.forEach(t-> System.out.println("yagippp :"+t.getText()));






driver.close();
    }
}
