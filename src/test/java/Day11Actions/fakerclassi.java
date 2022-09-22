package Day11Actions;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class fakerclassi {

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
    public void test1() {
        Actions actions = new Actions(driver);

            //"https://facebook.com"  Adresine gidin
            driver.get("https://www.facebook.com");
            //“create new account”  butonuna basin
            driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
            //“firstName” giris kutusuna bir isim yazin
            Faker faker = new Faker();
            WebElement isim = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));

            String email = faker.internet().emailAddress();// Aynı mail adresini girmesi için String bir değişkene atama yaptık
        /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
            actions.click(isim).sendKeys(faker.name().firstName()).
                    sendKeys(Keys.TAB).sendKeys(faker.name().lastName()). sendKeys(Keys.TAB).
                    sendKeys(email).
                    sendKeys(Keys.TAB).
                    sendKeys(email).
                    sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                    sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                    sendKeys(Keys.TAB).sendKeys("1982").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                    sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                    sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                    .sendKeys(Keys.ENTER).perform();

        }
}

