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

public class Q8 {
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
        //Category bolumundeki elementleri locate edin
        WebElement women=driver.findElement(By.xpath("(//div[@class='panel-heading'])[1]"));
        WebElement men=driver.findElement(By.xpath("(//div[@class='panel-heading'])[2]"));
        WebElement kids=driver.findElement(By.xpath("(//div[@class='panel-heading'])[3]"));

        //Category bolumunde 3 element oldugunu test edin
        List<WebElement> categorybolumu=driver.findElements(By.xpath("//div[@class='panel panel-default']"));

        Assert.assertTrue(categorybolumu.size()==3);



        //Category isimlerini yazdirin
      categorybolumu=driver.findElements(By.xpath("//div[@class='panel panel-default']"));
        for (WebElement each:categorybolumu
             ) {
            System.out.println("Category isimleri : " + each.getText());
        }



        //Sayfayi kapatin

        driver.close();






    }
}
