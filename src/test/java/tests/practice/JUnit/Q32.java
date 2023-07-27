package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q32 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accontlistsmenusu=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accontlistsmenusu).perform();

        // “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        // Acilan sayfada “Your Lists” yazisi oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='heading']")).isDisplayed());




    }
}
