package Calisma.bol;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class actionsbelangrijk {

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

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String handle= driver.getWindowHandle();
        //2."Login Portal" a  kadar asagi inin
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        // 4.Diger window'a gecin
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
        String handle1=driver.getWindowHandle();
        driver.switchTo().window(handle1);
        //5."username" ve  "password" kutularina deger yazdirin
        WebElement username= driver.findElement(By.xpath("//*[@id='text']"));
        username.sendKeys("yusuf");
        WebElement password= driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("12345");
        //6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedyazi="validation failed";
        Assert.assertEquals(expectedyazi,driver.switchTo().alert().getText());
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //Ilk sayfaya geri donun
        driver.switchTo().window(handle);
        //Ilk sayfaya donuldugunu test edin
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        Assert.assertEquals(handle,driver.getWindowHandle());
        // burdaki handle i yukarida tanimladigim icin tekrar tanimlama geregi duymadim. Ilk girdigimiz sayfanin handle degeri oldugu icin

        System.out.println(handle);
        System.out.println(driver.getWindowHandle());
    }
}
