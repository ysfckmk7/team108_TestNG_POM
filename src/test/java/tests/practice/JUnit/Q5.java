package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q5 {
    WebDriver driver;
    @Test
    public void test01(){

        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //facebook sayfasina gidin ve sayfa basliginin
        driver.get("https://www.facebook.com");
        //(title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        String expectedIcerik="facebook";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("test passed");
        }else{
            System.out.println("test faıled \ndogru baslık : " + actualTitle);
        }

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualURl=driver.getCurrentUrl();

        if (actualURl.contains(expectedIcerik)){
            System.out.println("test passed");
        }else{
            System.out.println("test faıled \ndogru url : " + actualURl);
        }

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");
        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        actualTitle=driver.getTitle();
        expectedIcerik="Walmart.com";
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("test passed");
        }else{
            System.out.println("test faıled \ndogru baslık : " + actualTitle);
        }
        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        //Sayfayi yenileyin
        driver.navigate().refresh();
        //Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        //Browser’i kapatin
        driver.close();

    }
}
