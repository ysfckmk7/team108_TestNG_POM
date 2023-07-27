package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q48Cozulemedi {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //Headers da bulunan basliklari yazdirin
        List<WebElement> headers=driver.findElements(By.xpath("//div[@class='rt-tr']"));

        int numarate=1;
        for (WebElement each:headers
             ) {
            System.out.println(numarate + "-" + each.getText());
            numarate++;
        }

        System.out.println("==============================");


        //3.sutunun basligini yazdirin

        System.out.println(driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]")).getText());


        //Tablodaki tum datalari yazdirin
        List<WebElement> tumdata=driver.findElements(By.xpath("//div[@class='rt-table']"));

        numarate=1;
        for (WebElement each:tumdata
        ) {
            System.out.println(numarate + "-" + each.getText());
            numarate++;
        }


        //Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        //Tablodaki satir sayisini yazdirin
       List<WebElement> satirsayisi= driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("satir sayisi : " +satirsayisi.size());
        //Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunsayisi= driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println("sutun sayisi : " +satirsayisi.size());
        //Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncukolon=driver.findElements(By.xpath("//div[@style='flex: 40 0 auto; width: 40px; max-width: 40px;']"));
        numarate=1;
        for (WebElement each:ucuncukolon
        ) {
            System.out.println(numarate + "-" + each.getText());
            numarate++;
        }

        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement kierra=driver.findElement(By.xpath("(//div[@role='gridcell'])[15]"));
        WebElement kierraSalary=driver.findElement(By.xpath("(//div[@role='gridcell'])[19]"));



        //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }

}
