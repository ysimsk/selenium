package Day13cookies;

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
import java.util.List;

public class webtables {

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
        /*
Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.
Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile sutunlara yani
hucrelere <td> tagı ile ulasilir.
 */
        login();
        table();
    }
    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi = "+sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
    }
    private void login() {
        //Bir class oluşturun : C02_WebTables
        //login( ) metodun oluşturun ve oturum açın.
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager
        //Password : Manager1!
        //table( ) metodu oluşturun

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }


}