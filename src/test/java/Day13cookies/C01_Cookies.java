package Day13cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C01_Cookies {
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

        //driver.close();
    }

    @Test
    public void test1(){
       // 1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

       // -tum cookie’leri listeleyin
     Set<Cookie>tumCookie=driver.manage().getCookies();
        System.out.println("tumCookie = " + tumCookie);
        int sayac=1;
        for (Cookie w:tumCookie
             ) {
            System.out.println(sayac+ ".ci cookie : "+w);
            System.out.println(w.getName());
            System.out.println(w.getValue());
        }
       // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesayisi=tumCookie.size();
        Assert.assertTrue(cookiesayisi>5);
       // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin  5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
       // 6-eklediginiz cookie’nin sayfaya eklendigini test edin
       // 7-ismi skin olan cookie’yi silin ve silindigini test edin
       // 8-tum cookie’leri silin ve silindigini test edin
    }

}
