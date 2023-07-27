package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q41 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        // “It’s gone!” mesajinin goruntulendigini dogrulayin

        WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(25));
        WebElement message=driver.findElement(By.xpath("//p[@id='message']"));
        Wait.until(ExpectedConditions.visibilityOf(message));

        // Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // It’s back mesajinin gorundugunu test edin
        WebElement ıtsback=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Wait.until(ExpectedConditions.visibilityOf(ıtsback));




    }

}
