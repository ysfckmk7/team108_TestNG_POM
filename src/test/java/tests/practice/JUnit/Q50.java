package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class Q50 {


    @Test
    public void test01() throws IOException {

        String dosyaYolu="src/test/java/tests/practice/JUnit/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sayfa1=workbook.getSheet("Sayfa1");
        //Adimlari takip ederek 1.satira kadar gidelim
        //4.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).createCell(4).setCellValue("Nufus");
        //2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(4).setCellValue("1500000");
        //10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue("250000");
        //15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue("54000");
        //Dosyayi kaydedelim
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //Dosyayi kapatalim
        workbook.close();
        fos.close();
        fis.close();

    }
}
