package Calisma.Automationexercise;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class question3 extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        //  1. Launch browser
        //  driver.get("https://www.google.com");

        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //  3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isEnabled());

        //  4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //  5. Verify 'Login to your account' is visible
        String expect="Login to your account";
        String actual=driver.findElement(By.xpath("//*[text()='Login to your account']")).getText();
        Assert.assertEquals(expect,actual);

        //  6. Enter incorrect email address and password
        WebElement mail= driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        mail.sendKeys("yusuff@gmail.com");
        WebElement password= driver.findElement(By.xpath("(//*[@name='password'])[1]"));
        password.sendKeys("12345");

        //  7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        //  8. Verify error 'Your email or password is incorrect!' is visible
        String incorrect="Your email or password is incorrect!";

        Assert.assertEquals(incorrect,driver.findElement(By.xpath("//*[@style='color: red;']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@style='color: red;']")).getText());


    }

}
