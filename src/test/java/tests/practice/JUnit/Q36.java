package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q36 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //Hover over Me First" kutusunun ustune gelin
        WebElement hoverfirstmenusu=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverfirstmenusu).sendKeys();
        //Link 1" e tiklayin
        actions.click(driver.findElement(By.xpath("//a[text()='Link 1']"))).perform();
        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        WebElement clickholdtusu=driver.findElement(By.xpath("//p[text()='Click and Hold!']"));
        actions.clickAndHold(clickholdtusu).perform();
        //“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[text()='Well done! keep holding that click now.....']")).getText());
        //“Double click me" butonunu cift tiklayin
        WebElement doubleclickme=driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleclickme).perform();

        driver.close();

       }
    }
