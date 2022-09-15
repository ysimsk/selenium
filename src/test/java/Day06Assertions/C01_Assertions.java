package Day06Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
Amazon sayfasina git
3 farkli test method'u olustur
- url'in "amazon" icergini test et
- title'in "facebook" icermedigini test et
- sol ust kosede amazon logosunun gorundugunu test et
 */

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
      driver.close();
}
@Test
    public void test1(){
      driver.get("https://www.amazon.com");
}

}
