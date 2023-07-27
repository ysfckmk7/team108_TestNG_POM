package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q18 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/ ");

        //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.bestbuy.com/"));
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        Assert.assertFalse(driver.getTitle().contains("Rest"));
        //logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed());
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Canada']")).isDisplayed());






    }
}
