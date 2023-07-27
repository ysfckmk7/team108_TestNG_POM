package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class kiwiTest {

    //https://www.kiwi.com sayfasina gidin
    //Cookies i reddedin
    //Sag ust kısımdan dil ve para birimi secenegını Turkıye ve TL olarak secin
    //Sectiginiz dil ve para birimini dogrulayın
    //Ucus secenegı olarak tek yon secelim
    //Kalkıs ve varis boxlarini temizleyerek kalkıs ve varıs ulkesını kendımız belırleyelım
    //Gıdıs arıhı kısmına erısım saglayarak gıdecegımız gunu secelim ve bookıng i iptal edelim
    //Sadece aktarmasız ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
    //Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 TL den kucuk oldugunnu dogrulayın






    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }





    @Test
    public void testkiw() throws InterruptedException {


        //https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com");
        //Cookies i reddedin
        driver.findElement(By.xpath("//div[text()='Reject all']")).click();
        //Sag ust kısımdan dil ve para birimi secenegını Turkıye ve TL olarak secin
        WebElement trybutonu=driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 jIgbVC'])[7]"));
        trybutonu.click();
        WebElement languagekutucugu=driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select select=new Select(languagekutucugu);
        select.selectByVisibleText("Türkçe");

        WebElement currencykutucugu=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        select=new Select(currencykutucugu);
        select.selectByVisibleText("Turkish lira - TRY");

        driver.findElement(By.xpath("//div[text()='Save & continue']")).click();

        //Sectiginiz dil ve para birimini dogrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='TRY']")).getText().contains("TRY"));
        Assert.assertTrue(driver.getCurrentUrl().contains("tr"));

        //Ucus secenegı olarak tek yon secelim
        driver.findElement(By.xpath("(//div[text()='Gidiş Dönüş'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Tek Yön']")).click();

        //Kalkıs ve varis boxlarini temizleyerek kalkıs ve varıs ulkesını kendımız belırleyelım
        driver.findElement(By.xpath("//div[@data-test='PlacePickerInputPlace-close']")).click();
        WebElement kalkıs=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        kalkıs.sendKeys("istanbul");
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        WebElement varıs=driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        varıs.sendKeys("madrid");
        driver.findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();

        //Gıdıs arıhı kısmına erısım saglayarak gıdecegımız gunu secelim ve bookıng i iptal edelim
        driver.findElement(By.xpath("//*[@class='Icon__StyledIcon-sc-psgqgs-0 jjVoBX']")).click();
        driver.findElement(By.xpath("//div[text()='Ara']")).click();

        //Sadece aktarmasız ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        driver.findElement(By.xpath("//div[text()='Aktarmalar']")).click();
        driver.findElement(By.xpath("//span[text()='Aktarmasız (direkt)']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='En ucuz']")).click();


        //Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 TL den kucuk oldugunnu dogrulayın
        String enucuz=driver.findElement(By.xpath("//strong[@data-test='ResultCardPrice']")).getText();
        enucuz=enucuz.replaceAll("\\D","");
        System.out.println(enucuz);
        int enucuzint=Integer.parseInt(enucuz);
        int istenenfiyat=5000;

        Assert.assertTrue(istenenfiyat>enucuzint);


    }




    @AfterTest
    public void teardown(){
        driver.close();

    }


}
