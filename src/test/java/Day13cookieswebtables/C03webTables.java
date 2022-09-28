package Day13cookieswebtables;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C03webTables extends TestBaseBeforeAfter  {


    @Test
    public void test1() {
        //Bir önceki class'daki adrese gidelim
//Login() methodunu kullanarak sayfaya giriş yapalım
        login();
        int satir=3;
        int sutun=4;

//input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
WebElement cel=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(cel.getText());
//Price başlığındaki tum numaraları yazdırınız
        List<WebElement> price=driver.findElements(By.xpath("//tbodytr//td[6]"));
        for (WebElement w:price
             ) {
            System.out.println("w.getText() = " + w.getText());
        }

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

