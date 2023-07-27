package tests.practice.JUnit;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q34 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //Yeni hesap olustur butonuna basalim
        WebElement hesapolusturbutonu=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        Actions actions=new Actions(driver);
        actions.click(hesapolusturbutonu).perform();
        //Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement adbutonu=driver.findElement(By.xpath("//input[@placeholder='First name']"));
        Faker faker=new Faker();
        actions.click(adbutonu).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).click()
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        //Kaydol tusuna basalim

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();







    }
}
