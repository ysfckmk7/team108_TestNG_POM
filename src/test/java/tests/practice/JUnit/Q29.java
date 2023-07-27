package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Q29 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String whdinternet=driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String whdnewindow="";

        Set<String> tumwhd=driver.getWindowHandles();
        for (String each:tumwhd
             ) {
            if (!each.equals(whdinternet)){
                whdnewindow=each;
            }
        }
        driver.switchTo().window(whdnewindow);
        Assert.assertTrue(driver.getTitle().contains("New Window"));
        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(whdinternet);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));




    }
}
