package Calisma.Automationexercise;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01 {
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
        // driver.close();
    }

    @Test
    public void test1() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully(Giriş sayfasının başarıyla göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed();
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        // 5. Verify 'New User Signup!' is visible("Yeni Kullanıcı Kaydı!"nın görünür olduğunu doğrulayın)
        driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed();
        // 6. Enter name and email address
        WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        name.sendKeys("yusuf");
        WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[2]"));
        email.sendKeys("yusuf2@gmail.com");
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible('HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        WebElement hesapBilgisi = driver.findElement(By.xpath("//*[text()='Address Information']"));
        Assert.assertTrue(hesapBilgisi.isDisplayed());
        // 9. Fill details:Title, Name, Email, Password, Date of birth(ayrintilari doldur)
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        Actions actions = new Actions(driver);
        WebElement isim = driver.findElement(By.xpath("//*[@id='name']"));
        // isim.sendKeys("yusuf");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("12345").
                sendKeys(Keys.TAB).sendKeys("14").sendKeys(Keys.TAB).
                sendKeys("april").sendKeys(Keys.TAB).sendKeys("1990").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 10. Select checkbox 'Sign up for our newsletter!'
        WebElement box = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        actions.moveToElement(box).click().perform();

        // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement box2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        actions.moveToElement(box2).click().perform();

        // 12. Fill details:First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        actions.sendKeys(Keys.ENTER).sendKeys("yusuf").sendKeys(Keys.TAB).sendKeys("simsek").sendKeys(Keys.TAB).
                sendKeys("wwww").sendKeys(Keys.TAB).sendKeys("Den Haag").sendKeys(Keys.TAB).sendKeys("Nederland").perform();
        WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
        //actions.click(country).sendKeys("Canada").perform();
        Select select = new Select(country);
        select.selectByIndex(2);
        actions.sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).sendKeys("holland").sendKeys(Keys.TAB).sendKeys("Amsterdam").sendKeys(Keys.TAB).
                sendKeys("2545Hb").sendKeys(Keys.TAB).sendKeys("1234567890").perform();


        // 13. Click 'Create Account button'
        WebElement create = driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
create.click();
// 14. Verify that 'ACCOUNT CREATED!' is visible
        // 15. Click 'Continue' button
        // 16. Verify that 'Logged in as username' is visible
        // 17. Click 'Delete Account' button
        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
}
