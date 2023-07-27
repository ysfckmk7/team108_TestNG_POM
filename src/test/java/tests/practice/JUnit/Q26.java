package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q26 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement iframeelementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeelementi);

        // Text Box’a “Merhaba Dunya!” yazin.

        WebElement yazielementi=driver.findElement(By.tagName("p"));
        yazielementi.clear();
        yazielementi.sendKeys("Merhaba Dunya...");

        driver.switchTo().parentFrame();

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).isDisplayed());




    }

}
