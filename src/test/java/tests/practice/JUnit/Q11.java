package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q11 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        //Delete butonu’nun gorunur oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).isDisplayed());
        //Delete tusuna basin
        driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@onclick='addElement()']")).isDisplayed());









    }
}
