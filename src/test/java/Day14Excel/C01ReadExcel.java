package Day14Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01ReadExcel {

    @Test

    public void test1() throws IOException {
        String dosyayolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyayolu);
        // olusturmus oldugumz dosyayi sistemde isleme alir
        Workbook workbook= WorkbookFactory.create(fis);
        // workbook objesi ile fis ile akisa aldigimiz dosyamizla bir excel
        // dosyasi olusturduk/
        Sheet sheet=workbook.getSheet("Sayfa1");
        //excel dosyamizda calismak istedigimiz sayfayi tanimladik
        Row row=sheet.getRow(3);
        // sayfa 1 deki 3. satira gitmek icin
        Cell cell= row.getCell(3);
        //satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir
        System.out.println(cell);
        String expecteddata="Cezayir";
        String actualdata=cell.toString();
        Assert.assertEquals(expecteddata,actualdata);
    }
}
