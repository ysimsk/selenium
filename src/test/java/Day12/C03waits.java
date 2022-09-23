package Day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03waits {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown() {
        driver.close();
    }
    @Test
    public void test1(){
        // 1. Bir class olusturun : WaitTest
// 2. Iki tane metod olusturun : implicitWait() , explicitWait()
//    Iki metod icin de asagidaki adimlari test edin.
// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
// 4. Remove butonuna basin.
// 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
// 6. Add buttonuna basin
// 7. It's back mesajinin gorundugunu test edin
    }
}
