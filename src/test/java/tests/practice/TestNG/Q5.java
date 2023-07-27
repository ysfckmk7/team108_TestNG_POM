package tests.practice.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q5 {

    @Test
    public void test01(){

        QdPage qdPage=new QdPage();

        // https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qdPage.cookiesKabulButonu.click();
        // login linkine basin
        qdPage.ilkLoginLinki.click();
        // Kullanici email'i olarak valid email girin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        // Kullanici sifresi olarak valid sifre girin
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        // Login butonuna basarak login olun
        qdPage.loginButonu.click();
        // Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();
    }
}
