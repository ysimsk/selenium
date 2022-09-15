package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class basliga10keztiklama {
    public static void main(String[] args) throws InterruptedException {

        //    1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
//    2- Add Element butonuna 10 kez basinız
//    3- 10 kez Add element butonuna basıldığını test ediniz
//    4 - Delete butonuna görünmeyene kadar basınız
//    5- Delete butonunun görünmediğini test ediniz
//    6- Sayfayı kapatınız

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        WebElement addbuton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        WebElement delete= driver.findElement(By.xpath("//button[@class='added-manually']"));








    }
}
