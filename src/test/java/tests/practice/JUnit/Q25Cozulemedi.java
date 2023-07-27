package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q25Cozulemedi {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username : admin
        //password : admin
        //Basarili sekilde sayfaya girildigini dogrulayin

        JavascriptExecutor js= (JavascriptExecutor) driver;

        driver.switchTo().alert().sendKeys("admin");
      js.executeScript("arguments[0].click();","admin");






    }
}
