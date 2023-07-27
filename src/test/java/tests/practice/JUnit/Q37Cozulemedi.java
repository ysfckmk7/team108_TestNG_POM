package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q37Cozulemedi {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //video’yu gorecek kadar asagi inin
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement videoelementi=driver.findElement(By.xpath("//div[@style='background-image: url(\"https://i.ytimg.com/vi_webp/owsfdh4gxyc/hqdefault.webp\");']"));
        js.executeScript("arguments[0].scrollIntoView();",videoelementi);

        //videoyu izlemek icin Play tusuna basin
        js.executeScript("arguments[0].click();",videoelementi);


        //videoyu calistirdiginizi test edin

        //js.executeScript("alert('JUnit Bitti');");






    }
}
