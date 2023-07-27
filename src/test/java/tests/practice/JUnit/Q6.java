package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q6 {


    WebDriver driver;

    @Test
    public void test01(){

        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



        //Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String expedtedIcerik="youtube";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expedtedIcerik)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed\ndogru baslık : " + actualTitle);
        }

         //Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyors doğru URL'yi yazdırın.
        String actualURL=driver.getCurrentUrl();
        expedtedIcerik="youtube";

        if (actualURL.contains(expedtedIcerik)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed\ndogru baslık : " + actualURL);
        }
         //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://amazon.com/");
         //Youtube sayfasina geri donun
        driver.navigate().back();
         //Sayfayi yenileyin
        driver.navigate().refresh();
        //Amazon sayfasina donun
        driver.navigate().forward();
         //Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
         //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,Yoksa doğru başlığı(Actual Title) yazdırın.
        actualTitle=driver.getTitle();
        expedtedIcerik="Amazon";
        if (actualTitle.contains(expedtedIcerik)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed\ndogru baslık : " + actualTitle);
        }

        //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        actualURL=driver.getCurrentUrl();
        expedtedIcerik="https://www.amazon.com/";

        if (actualURL.contains(expedtedIcerik)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed\ndogru baslık : " + actualURL);
        }
        //Sayfayi kapatin
        driver.close();


















    }
}
