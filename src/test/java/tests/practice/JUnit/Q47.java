package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q47 {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // "https://www.amazon.com/" adresine gidin
        driver.get("https://www.amazon.com/");
        //  Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.END).perform();
        //  Web table tum body’sini yazdirin
        List<WebElement> tables=driver.findElements(By.xpath("//tbody"));
        int numarate=1;
        for (WebElement each:tables
             ) {
            System.out.println(numarate + "-" + each.getText());
            numarate++;
        }

        //  Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> satirsayisi=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(satirsayisi.size(),10);

        //  Tum satirlari yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody/tr")).getText());
        //  Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunsayisi=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,sutunsayisi.size());
        //  5.sutunu yazdirin
        List<WebElement> besinciSutun=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        numarate=1;
        for (WebElement each:besinciSutun
        ) {
            System.out.println(numarate + "-" + each.getText());
            numarate++;
        }
        //  Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        System.out.println(parametre(3, 5));
        String asd=parametre(5,7);
        String expectedIcerik="Book reviews";
        Assert.assertTrue(asd.contains(expectedIcerik));


    }

    public String parametre(int satir,int sutun){

        //      "//tbody/tr[3]/td[5";

        String xdata="//tbody/tr["+satir+"]/td["+sutun+"]";

        String istenenData=driver.findElement(By.xpath(xdata)).getText();

        return istenenData;
    }
}
