package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Q39 {
    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        // Dosyanın başarıyla indirilip indirilmediğini test edelim
        Thread.sleep(3000);


        String dosyaYolu="C:\\Users\\yusuf\\OneDrive\\Desktop\\logo.png";


        boolean sonuc = Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);


        System.out.println(System.getProperty("user.home"));

        dosyaYolu="/C:\\Users\\yusuf\\OneDrive\\Masaüstü";
        dosyaYolu= System.getProperty("user.home") + "\\Desktop\\logo.png";



        System.out.println(System.getProperty("user.dir"));

        dosyaYolu = System.getProperty("user.home") + "\\Downloads\\logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println("islem basarılı");





    }
}
