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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class zeroweb {

  /*



13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

   */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
      //1. http://zero.webappsecurity.com/ Adresine gidin
      driver.get("http://zero.webappsecurity.com/");
    }
    @AfterClass
  public static void teardown(){

      driver.close();
    }
    @Test
      public void test1(){
      driver.findElement(By.xpath("//button")).click();
      driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
      driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
      driver.findElement(By.name("submit")).click();
      driver.navigate().back();
      driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
      driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
      driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
      WebElement ddm= driver.findElement(By.xpath("//*[@id='pc_currency']"));
      Select select = new Select(ddm);
      select.selectByIndex(6);
    //  9. “amount” kutusuna bir sayi girin

      driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("349");

      //10. “US Dollars” in secilmedigini test edin
      WebElement dolar= driver.findElement(By.id("pc_inDollars_true"));
      if(!dolar.isSelected()){
//11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
      }

//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin

      driver.findElement(By.id("pc_calculate_costs")).click();
      driver.findElement(By.id("purchase_cash")).click();

//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

      String actual= driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']")).getText();
      String expsct="Foreign currency cash was successfully purchased.";

      Assert.assertEquals(actual,expsct);



    }
    }

