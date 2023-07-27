package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q40 {


    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


         //https://the-internet.herokuapp.com/upload adresine gideli
        driver.get("https://the-internet.herokuapp.com/upload");
        // chooseFile butonuna basalim

        //Yuklemek istediginiz dosyayi secelim

        String dinamikDosyaYolu= System.getProperty("user.home")+"\\Downloads\\logo.png";
        WebElement chooseFileButonu= driver.findElement(By.id("file-upload"));

        chooseFileButonu.sendKeys(dinamikDosyaYolu);


        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
         //“File Uploaded!” textinin goruntulendigini test edelim
        WebElement fileuploaded=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileuploaded.isDisplayed());




         }
}
