package Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class dragdrop {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {


//https://demoqa.com/droppable adresine gidelim
            driver.get("https://demoqa.com/droppable");
        WebElement dragme =driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropme=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragme,dropme).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Dropped!']")).isDisplayed());

    }



}
