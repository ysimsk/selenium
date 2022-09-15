package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Beforeclassafterclass {
    static WebDriver driver;

    @BeforeClass
    public static void beforeclass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
    }

   @Test
   public void test1(){
        driver.get("https://www.amazon.com");
   }

    @Test
    public  void test2(){
        driver.get("https://www.bol.com");
    }



    @AfterClass
    public static void teardown(){

        driver.close();
    }


}
