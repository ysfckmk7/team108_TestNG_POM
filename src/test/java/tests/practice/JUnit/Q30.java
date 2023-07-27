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

public class Q30 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizili alan uzerinde sag click yapin
        WebElement cızıliAlan=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cızıliAlan).perform();

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        Assert.assertTrue(driver.switchTo().alert().getText().contains("You selected a context menu"));
        //Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();



        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


        String ilksayfahwd=driver.getWindowHandle();
        String ikincisayfahwd="";
        Set<String> tumwhd=driver.getWindowHandles();

        for (String each:tumwhd
        ) {
            if(!each.equals(ilksayfahwd)){
                ikincisayfahwd=each;
            }
        }

        driver.switchTo().window(ikincisayfahwd);
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).isDisplayed());


    }
}
