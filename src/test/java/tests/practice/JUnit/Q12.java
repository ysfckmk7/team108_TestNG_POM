package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q12 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Spend less"));
        //Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_gc']")).click();
        //Birthday butonuna basin
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();
        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();
        //Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//button[@value='25']")).click();
        //Urun ucretinin 25$ oldugunu test edin
        Assert.assertFalse(driver.findElement(By.xpath("//span[text()='$25.00']")).getText().contains("25$"));
        //Sayfayi kapatin
        driver.close();




    }
}
