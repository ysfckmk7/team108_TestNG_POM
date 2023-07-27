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
import java.util.List;

public class Q23 {
    WebDriver driver;


    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));


        List<WebElement> kategorilistesi=driver.findElements(By.xpath("//div[@class='nav-search-scope nav-sprite']"));

        int expectedsayi=45;
        int actualsayi=kategorilistesi.size();

        Assert.assertFalse(expectedsayi==actualsayi);

    }
    @Test
    public void test02(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Test 2
        //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Kategori menusunden Books secenegini secin
        WebElement kategorimenusu=driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']"));
        kategorimenusu.click();
        driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();
        //Arama kutusuna Java yazin ve aratin
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.click();
        aramakutusu.sendKeys("Java"+ Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        String sonucsayisi=driver.findElement(By.xpath("//div[@class='sg-col-inner']")).getText();
        System.out.println(sonucsayisi);
        //Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucsayisi.contains("Java"));




    }
}
