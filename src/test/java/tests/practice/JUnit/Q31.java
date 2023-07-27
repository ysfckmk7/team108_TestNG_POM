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

public class Q31 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragme=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drophere=driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragme,drophere).perform();

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed());



    }
}
