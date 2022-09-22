package Day08Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04Iframe {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
        //driver.close();
    }


        @Test
        public void test1() {
            //  https://www.youtube.com/embed/owsfdh4gxyc   adresine gidiniz
            driver.get("https://html.com/tags/iframe/");
            //Youtube videosunu calistiriniz
            WebElement youtubeFrame=driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
           driver.switchTo().frame(youtubeFrame);
            driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

    }

}
