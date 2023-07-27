package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q3 {

    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.getPageSource());
        System.out.println(driver.manage().window().getSize());
        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();
        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();
        //Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        driver.manage().window().getPosition();
        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        //Sayfayi kapatin
        driver.close();















    }
}
