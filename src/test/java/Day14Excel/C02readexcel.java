package Day14Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02readexcel {
    @Test
    public void test1() throws IOException {
        String dosyayolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        // olusturmus oldugumz dosyayi sistemde isleme alir
        Workbook workbook= WorkbookFactory.create(fis);
        // workbook objesi ile fis ile akisa aldigimiz dosyamizla bir excel
        // dosyasi olusturduk/
       String actualdata=workbook.
               getSheet("Sayfa1").getRow(3).
               getCell(3).toString();

        System.out.println(actualdata);



    }
}
