package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q43 {

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //"Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverıverfirst=driver.findElement(By.xpath("//button[text()=\"Hover Over Me First!\"]"));
        actions.moveToElement(hoverıverfirst).perform();
        //"Link 1" e tiklayin
        driver.findElement(By.xpath("//a[text()=\"Link 1\"]")).click();
        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //"Click and hold" kutusuna basili tutun
        WebElement clickhold=driver.findElement(By.xpath("//p[text()=\"Click and Hold!\"]"));
        actions.clickAndHold(clickhold).perform();
        //"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[text()=\"Well done! keep holding that click now.....\"]")).getText());
        //"Double click me" butonunu cift tiklayin
        WebElement doubleclick=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleclick).perform();

    }
}
