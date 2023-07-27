package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Q46 {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        //tum cookie’leri listeleyin
        Set<Cookie> tumcookies=driver.manage().getCookies();

        int numarate=1;
        for (Cookie each:tumcookies
             ) {
            System.out.println(numarate + "-" + each);
            numarate++;
        }

        System.out.println("=======================================");

        //Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(tumcookies.size()>5);
        //ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));
        //ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        //eklediginiz cookie’nin sayfaya eklendigini test edin
        driver.manage().addCookie(cookie);

        tumcookies=driver.manage().getCookies();

         numarate=1;
        for (Cookie each:tumcookies
        ) {
            System.out.println(numarate + "-" + each);
            numarate++;
        }

        System.out.println("==========================================0");

        //ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        if (!tumcookies.contains("skin")){

            tumcookies=driver.manage().getCookies();

            numarate=1;
            for (Cookie each:tumcookies
            ) {
                System.out.println(numarate + "-" + each);
                numarate++;
            }
        }

        System.out.println("===============================");
        //tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        tumcookies=driver.manage().getCookies();

        numarate=1;
        for (Cookie each:tumcookies
        ) {
            System.out.println(numarate + "-" + each);
            numarate++;
        }


    }
}
