package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q21 {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://facebook.com
        driver.get("https://facebook.com");
        //Cookies’i kabul edin
        //Create an account buton’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //Radio button elementlerini locate edin ve size uygun olani secin
        WebElement female=driver.findElement(By.xpath("//label[text()='Female']"));
        WebElement male=driver.findElement(By.xpath("//label[text()='Male']"));
        WebElement custom=driver.findElement(By.xpath("//label[text()='Custom']"));
        male.click();


    }
    }
