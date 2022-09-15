package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class amazon {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
@Test
        public void test1() {
    WebElement button = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
    Select select = new Select(button);

    select.selectByIndex(2);
    System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    searchbox.sendKeys("yusuuf", Keys.ENTER);

    WebElement sonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    System.out.println("sonuc.getText() = " + sonuc.getText());

   List<WebElement> src= driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro']"));
    System.out.println("snc.getText() = " + src.get(0).getText());
    for (WebElement each:src
         ) {
        System.out.println("each = " + each.getText());
    }
}
@After
    public void teardown(){
        driver.close();
}

}