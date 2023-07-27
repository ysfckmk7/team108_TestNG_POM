package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q2 {

              //Youtube ana sayfasina gidelim . https://www.youtube.com/
              //Amazon soyfasina gidelim. https://www.amazon.com/
              //Tekrar YouTube’sayfasina donelim
              //Yeniden Amazon sayfasina gidelim
              //Sayfayi Refresh(yenile) yapalim
              //Sayfayi kapatalim / Tum sayfalari kapatalim


    WebDriver driver;

    @Test
    public void test01(){

        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        //Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();











    }







}
