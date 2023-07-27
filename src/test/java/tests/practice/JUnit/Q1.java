package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q1 {

       //Amazon sayfasina gidelim. https://www.amazon.com/
       //Sayfa basligini(title) yazdirin
       //Sayfa basliginin “Amazon” icerdigini test edin
       //Sayfa adresini(url) yazdirin
       //Sayfa url’inin “amazon” icerdigini test edin.
       //Sayfa handle degerini yazdirin
       //Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
       //Sayfayi kapatin.

       WebDriver driver;
       @Test
           public void test01(){

        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

           //Amazon sayfasina gidelim. https://www.amazon.com/
           driver.get("https://www.amazon.com/");
           //Sayfa basligini(title) yazdirin
           System.out.println(driver.getTitle());
           //Sayfa basliginin “Amazon” icerdigini test edin
           Assert.assertTrue(driver.getTitle().contains("Amazon"));
           //Sayfa adresini(url) yazdirin
           System.out.println(driver.getCurrentUrl());
           //Sayfa url’inin “amazon” icerdigini test edin.
           Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
           //Sayfa handle degerini yazdirin
           System.out.println(driver.getWindowHandle());
           //Sayfayi kapatin.
           driver.close();



    }

}
