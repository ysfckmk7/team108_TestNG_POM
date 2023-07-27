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
import java.util.Set;

public class Q45 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //"http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //"Login Portal" a kadar asagi inin
        WebElement loginportal=driver.findElement(By.xpath("//h4[text()='Login Portal']"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(loginportal).perform();
        String whdilk=driver.getWindowHandle();
        String whdikinci="";
        //"Login Portal" a tiklayin
        loginportal.click();
        Set<String> tumwhd=driver.getWindowHandles();
        for (String each: tumwhd
             ) {
            if (!each.equals(whdilk)){
                whdikinci=each;
            }
        }
        //Diger window'a gecin
        driver.switchTo().window(whdikinci);



        //"username" ve "password" kutularina deger yazdirin
        WebElement username=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        username.sendKeys("Ali");
        password.sendKeys("Atay");
        //"login" butonuna basin
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        //Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String alertyazisi=driver.switchTo().alert().getText();
        Assert.assertTrue(alertyazisi.contains("validation failed"));
        //Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //Ilk sayfaya geri donun
        driver.switchTo().window(whdilk);
        //Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='My Courses & Promo Codes']")).isDisplayed());





    }
}
