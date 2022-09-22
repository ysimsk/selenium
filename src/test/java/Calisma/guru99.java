package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class guru99 {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }
  @Test
  public void test1() throws InterruptedException {
        driver.get("https://www.demo.guru99.com");
     // WebElement drf=driver.findElement(By.xpath("//*[text()='Accept All']"));
     // drf.click();
     // System.out.println("drv.getText() = " + drv.getText());
      WebElement email= driver.findElement(By.xpath("//*[@type='text']"));
      email.sendKeys("yusuf@gmail.com");
      WebElement submit= driver.findElement(By.xpath("//*[@type='submit']"));
      submit.click();
      Thread.sleep(3000);
  }

}