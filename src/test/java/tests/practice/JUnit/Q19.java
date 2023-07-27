package tests.practice.JUnit;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q19 {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("//yt-icon[@id='logo-icon']")).isDisplayed());
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().contains("youtube"));





    }
}
