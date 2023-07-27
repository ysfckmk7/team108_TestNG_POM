package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q10 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");
        //Arama kutusuna “city bike” yazip aratin
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("city bike"+ Keys.ENTER);
        //Görüntülenen sonuçların sayısını yazdırın
        List<WebElement> sonucelementi=driver.findElements(By.tagName("a"));
        System.out.println("Görüntülenen sonuçların sayısı : " + sonucelementi.size());

        //Listeden ilk urunun resmine tıklayın.
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();









    }
}
