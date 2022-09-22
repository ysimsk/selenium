package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class yanlismailsorusu {
    /*
   Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter'a
bastigimizda "Invalid email address" uyarisi ciktigini test edelim


 */
static WebDriver driver;

@BeforeClass
    public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    driver.get("http://automationpractice.com/index.php");

}
@AfterClass
    public static void teardown(){
    driver.close();
}
@Test
    public void test1()  {
//Sign in butonuna basalim
    WebElement signin= driver.findElement(By.xpath("//*[@class='login']"));
  signin.click();
 // Thread.sleep(3000);

   //Email kutusuna @isareti olmayan bir mail yazip enter'a

    WebElement email= driver.findElement(By.xpath("//input[@id='email_create']"));
    email.sendKeys("ytoprak396gmail.com", Keys.ENTER);

  //  bastigimizda "Invalid email address" uyarisi ciktigini test edelim
    String expesctertext="\"Invalid email address\"";


}
@Test
    public void test2(){
    WebElement invalid= driver.findElement(By.id("create_account_error"));
    Assert.assertFalse(invalid.isDisplayed());

    System.out.println("invalid.isDisplayed() = " + invalid.isDisplayed());

}
}
