package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q44Cozulemedi {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //“Our Products” butonuna basin


        WebElement asd=driver.findElement(By.xpath("//a[text()='Our Products']"));
       asd.click();
        //“Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()=\"Cameras\"]")).click();
        //Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //“close” butonuna basin
        driver.switchTo().alert().dismiss();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("//a[text()=\"WebdriverUniversity.com (IFrame)\"]")).click();
        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"My Courses & Promo Codes\"]")).isDisplayed());






    }
    }
