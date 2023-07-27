package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q13 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //Berlin’i 3 farkli relative locator ile locate edin
        WebElement berlin = driver.findElement(By.xpath("//*[@*='pid7_thumb']"));
        WebElement bayarea=driver.findElement(By.xpath("//img[@id='pid8_thumb']"));
        WebElement nyc=driver.findElement(By.xpath("//img[@id='pid3_thumb']"));
        WebElement sailor=driver.findElement(By.xpath("//img[@id='pid11_thumb']"));



        WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));
        System.out.println("berlin elementi id : " + berlin1.getAttribute("id"));

        WebElement berlin2=driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(bayarea));
        System.out.println("berlin elementi id : " + berlin2.getAttribute("id"));

        WebElement berlin3=driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor));
        System.out.println("berlin elementi id : " + berlin3.getAttribute("id"));


        //Relative locator’larin dogru calistigini test edin







    }
}
