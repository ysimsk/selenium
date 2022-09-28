package Day15screenshot;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class screenshot extends TestBaseBeforeAfter {


    @Test
    public void test1() throws IOException {
    //amazon sayfasina gidelim tum sayfanin resmini alalim

    driver.get("https://www.amazon.com");

        TakesScreenshot ts= (TakesScreenshot) driver;

        File sayfaresmi=ts.getScreenshotAs(OutputType.FILE);


        FileUtils.copyFile(sayfaresmi,new File("target/ekrangoruntusu/allPage.jpeg"));

    }


}
