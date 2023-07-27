package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q9 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //Sayfada 147 adet link bulundugunu test edin.

        List<WebElement> linkliste=driver.findElements(By.tagName("a"));

        int expectedlink=147;
        int actuallink=linkliste.size();

        if (expectedlink==actuallink){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        //Products linkine tiklayin
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //special offer yazisinin gorundugunu test edin
       WebElement specialofferimg=driver.findElement(By.xpath("//img[@id='sale_image']"));
        Assert.assertTrue(specialofferimg.isDisplayed());



        //Sayfayi kapatin
        driver.close();











    }
}
