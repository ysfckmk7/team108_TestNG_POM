package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q7 {

    WebDriver driver;

    @Test
    public void test01(){

        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //https://www.amazon.com adresine gidin
        driver.get("https://www.amazon.com/");
        //amazon arama kutusunu locate edin
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //arama kutusuna “Nutella” yazdirin
        aramakutusu.sendKeys("Nutella");
        //arama islemini yapabilmek icin ENTER tusuna basin
        aramakutusu.submit();




    }
}
