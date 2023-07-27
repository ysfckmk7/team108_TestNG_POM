package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q49{

    @Test
    public void test01() throws IOException {

        String dosyaYolu="src/test/java/tests/practice/JUnit/ulkeler.xlsx";


       FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        //satirdaki 2.hucreye gidelim ve yazdiralim
        Sheet sayfa1=workbook.getSheet("Sayfa1");
        Row row=sayfa1.getRow(1);
        Cell cell=row.getCell(0);

        System.out.println(cell.toString());

        //3.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdir
        row=sayfa1.getRow(2);
        cell=row.getCell(1);

        String ucuncuSatir=cell.toString();
        System.out.println(ucuncuSatir);


        //2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
       String baskent= sayfa1.getRow(1).getCell(3).toString();
        Assert.assertTrue(baskent.equals("Kabil"));

        // Satir sayisini bulalim
        System.out.println("Sayfa1'in satir sayisi : " +(workbook.getSheet("Sayfa1").getLastRowNum()+1));

        // Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Sayfa2'in fiziki sayisi : " +(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows()));
        // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim


        Map<String,String> ulkeler=new TreeMap<>();

        int isimBaskentSonındex=workbook.getSheet("Sayfa1").getLastRowNum();



        for (int i =1; i <=isimBaskentSonındex ; i++) {
            String isim=sayfa1.getRow(i).getCell(0).toString();
            baskent=sayfa1.getRow(i).getCell(1).toString();

            ulkeler.put(isim,baskent);

        }

        System.out.println(ulkeler);





    }
}
