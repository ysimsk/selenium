package Day10Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01Actions {

    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test(){
        //amazon a gidelim
        // account menusunden creat a list linkine tiklayalim
        driver.get("https://www.amazon.com");




    }

}
