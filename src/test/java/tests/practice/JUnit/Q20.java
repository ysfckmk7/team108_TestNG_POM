package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q20 {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement check1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement check2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!check1.isSelected()){
            check1.click();
        }
        //Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!check2.isSelected()){
            check2.click();
        }






    }
    }
