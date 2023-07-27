package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q24 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        //Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        //“Currency” drop down menusunden Eurozone’u secin
        WebElement currency=driver.findElement(By.xpath("//select[@name='currency']"));
        currency.click();
        driver.findElement(By.xpath("//option[text()='Eurozone (euro)']")).click();
        //“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("(//input[@name='amount'])[2]")).sendKeys("70");
        //“US Dollars” in secilmedigini test edin
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='pc_inDollars_true']")).isSelected());
        //“Selected currency” butonunu secin
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();
        //“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='alert_content']")).isDisplayed());


    }
    }
