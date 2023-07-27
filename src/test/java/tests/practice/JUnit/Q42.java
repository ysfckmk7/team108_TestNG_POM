package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q42 {

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
        // Textbox’in etkin olmadigini(enabled) dogrulayın
        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());
        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(40));
        WebElement enable=driver.findElement(By.xpath("//button[text()='Enable']"));

        enable.click();
        Wait.until(ExpectedConditions.elementToBeClickable(enable));
        // “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement istsenable=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Wait.until(ExpectedConditions.visibilityOf(istsenable));

        // Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());





    }
}
