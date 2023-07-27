package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q15 {


    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



            //http://zero.webappsecurity.com sayfasina gidin
         driver.get("http://zero.webappsecurity.com ");
            //Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
            //Login alanine “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
            //Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
            //Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
            //Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
            //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("70");
            //tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("2020-09-10");
            //Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();
            //“The payment was successfully submitted.” mesajinin ciktigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']")).isDisplayed());



         }

}
