package Calisma;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class excel {



    @Test
    public void excelTest1() throws IOException {


        //  - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        String hucreDegeri=workbook.getSheet("Sayfa1").getRow(2).getCell(4).toString();
        System.out.println(hucreDegeri);

        //  - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        //   - 2.satir 4.cell'in afganistan'in baskenti oldugunu test edelim
        String expectedData="Kabul";
        String actualData=hucreDegeri.toString();
        Assert.assertNotEquals(expectedData,actualData);
        //    - Satir sayisini bulalim
        //  - Fiziki olarak kullanilan satir sayisini bulun
        //   - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedeli
    }

}
