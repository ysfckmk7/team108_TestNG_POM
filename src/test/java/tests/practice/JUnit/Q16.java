package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q16 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //cookies uyarisini kabul ederek kapatin
        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Google"));
        //Arama cubuguna “Nutella” yazip aratin
        WebElement aramakutusus=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        aramakutusus.sendKeys("Nutella"+ Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        WebElement sonucyazisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucyazisi.getText());
        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
         String sonuctest=sonucyazisi.getText().replaceAll("\\D","");
         sonuctest=sonuctest.substring(0,9);
         int sonuctestint=Integer.parseInt(sonuctest);
        System.out.println(sonuctest);

        Assert.assertTrue(sonuctestint>1000000);
        //Sayfayi kapatin
        driver.close();







    }
}
