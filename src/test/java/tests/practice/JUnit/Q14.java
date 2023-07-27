package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q14 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //arama kutusunu locate edelim
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //“Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucyazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucyazisi.getText());
        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        driver.navigate().back();
        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfabaslıklıste=driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        int numarate=1;
        for (WebElement each:sayfabaslıklıste
        ) {
            System.out.println(numarate + "-" + each.getText());
            numarate++;
        }













    }
}
