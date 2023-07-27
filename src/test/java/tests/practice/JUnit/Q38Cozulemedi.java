package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Q38Cozulemedi {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //amazon gidin
        driver.get("https://wwwamazon.com/");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));

        List<WebElement> dropdownmenu=driver.findElements(By.xpath("//div[@id='nav-search-dropdown-card']"));


        for (WebElement each:dropdownmenu
             ) {
            System.out.println(each.getText());

        }

        //dropdown menude 40 eleman olduğunu doğrulayın

        Assert.assertFalse(dropdownmenu.size()==40);





    }

        @Test
        public void test02() {

            System.setProperty("webdriver.http.factory", "jdk-http-client");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://wwwamazon.com/");

            //      Test02
            //dropdown menuden elektronik bölümü seçin
            WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
            WebElement dropdownmenu=driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']"));
            dropdownmenu.click();
            driver.findElement(By.xpath("//*[text()='Electronics']")).click();

            //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
            aramakutusu.sendKeys("iphone"+ Keys.ENTER);
            String sonucsayisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
            //sonuc sayisi bildiren yazinin iphone icerdigini test edin
            Assert.assertTrue(sonucsayisi.contains("iphone"));
            //ikinci ürüne relative locater kullanarak tıklayin

            WebElement ilkurun=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            WebElement ikinciUrun=driver.findElement(RelativeLocator
                    .with(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")).toRightOf(ilkurun));

            ikinciUrun.click();
            //ürünün title'ni variable’a assign edip ürünü sepete ekleyelim

            String uruntitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
            System.out.println(uruntitle);




    }

    @Test
    public void test03() throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://wwwamazon.com/");


        String ilkwhd=driver.getWindowHandle();

        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wwwamazon.com/");
        //dropdown’dan bebek bölümüne secin

        Set<String> tumwhd=driver.getWindowHandles();

        String ikinciwhd="";
        for (String each:tumwhd
             ) {
            if (!each.equals(ilkwhd)){
                ikinciwhd=each;
            }
        }

        driver.switchTo().window(ikinciwhd);
        WebElement dropdownmenu=driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']"));
        dropdownmenu.click();
        driver.findElement(By.xpath("//*[text()='Baby']")).click();
        Thread.sleep(3000);

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramakutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.click();
        aramakutusu.sendKeys("bebek puset"+Keys.ENTER);


        //sonuç yazsının puset içerdiğini test edin
        String sonucyazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(sonucyazisi.contains("puset"));
        //üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciurun=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        WebElement ucuncuUrun=driver.findElement(RelativeLocator.with(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).below(ikinciurun));

        ucuncuUrun.click();
        // title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String uruntitle=ucuncuUrun.getText();
        System.out.println(uruntitle);

    }

}
