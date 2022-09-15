package Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class beforetesti {
    WebDriver driver;

    @Before
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

    }

    @Test
    public void test2(){

        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown(){
        driver.close();
    }

}
