package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Q51 {
    WebDriver driver;

    @Test
    public void test01() throws IOException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




        //amazon anasayfaya gidin

        driver.get("https://amazon.com/");
        //amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        //Nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String aramasonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramasonucu.contains("Nutella"));
        //sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin

        TakesScreenshot ts= (TakesScreenshot) driver;

        File tumsayfaSs=new File("target/Screenshout.png");

        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumsayfaSs);



    }
}
