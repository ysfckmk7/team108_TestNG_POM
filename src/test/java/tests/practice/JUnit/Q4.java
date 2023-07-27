package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q4 {

    WebDriver driver;
    @Test
    public void test01(){


        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin

        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        //Sayfayi kapatin
        driver.close();













    }
}
