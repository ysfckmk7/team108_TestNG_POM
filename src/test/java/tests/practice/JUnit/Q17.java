package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q17 {

    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        //Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        //Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkurun=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        //Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        //Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String sepeturunu=driver.findElement(By.xpath("//div[@class='cart_item_label']")).getText();
        Assert.assertTrue(sepeturunu.contains("carry.allTheThings() with the sleek, " +
                "streamlined Sly Pack that melds uncompromising style with unequaled " +
                "laptop and tablet protection."));
        //Sayfayi kapatin
        driver.close();









    }
}
