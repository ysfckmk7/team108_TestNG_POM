package tests.practice.TestNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.Testt.KayıtKimlikDogrulama;
import pages.Testt.LoginPage;
import pages.Testt.MyPage;
import pages.Testt.OnlineEgitimlerPage;
import utilities.ConfigReader;
import utilities.Driver;

public class QTest {
    // Kullanıcı https://www.iienstitu.com/en sayfasina gider.
    // Login butonuna tiklar.
    // Giriş bilgilerini girer ve basarili sekilde giris yaptigini test eder.
    // Headers da bulunan egitimler kismina tiklar.
    // Acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
    // Ucretsiz egitimlerden herhangi birini girer
    // Kimlik dogrulama islemlerini girer
    // Egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
    // Kullanici profil kismindan dersi basarili bir sekilde kaydedildigini test eder

    UdemyHomePage homepage=new UdemyHomePage();
    LoginPage loginPage=new LoginPage();

    MyPage myPage=new MyPage();

    OnlineEgitimlerPage egitim=new OnlineEgitimlerPage();

    KayıtKimlikDogrulama kayitDogrulama=new KayıtKimlikDogrulama();


    @Test
    public void test01(){
        Driver.getDriver().get("https://www.iienstitu.com/en");
        // Login butonuna tiklar.
        homepage.loginButtonHomePage.click();
        // Giriş bilgilerini girer ve basarili sekilde giris yaptigini test eder.
        loginPage.loginEmailBox.sendKeys(ConfigReader.getProperty("email"));
        loginPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("password"));
        loginPage.submitButton.click();
        Assert.assertTrue(myPage.loginverification.isDisplayed());
        // Headers da bulunan egitimler kismina tiklar.
        myPage.egitimlerOnHeaders.click();
        // Acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
        Select select=new Select(egitim.siralamaOptions);
        select.selectByValue("price_ASC");
        // Ucretsiz egitimlerden herhangi birini girer
        myPage.freeEgitim.click();
        // Kimlik dogrulama islemlerini girer
        myPage.egitimKayit.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(kayitDogrulama.kayıtemail).sendKeys(ConfigReader.getProperty("email"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("neo")
                .sendKeys(Keys.TAB)
                .sendKeys("anderson")
                .sendKeys(Keys.TAB)
                .sendKeys("Kocaeli")
                .sendKeys(Keys.TAB)
                .sendKeys("41255")
                .sendKeys(Keys.TAB)
                .sendKeys("İzmit") .perform();
        kayitDogrulama.odemeYap.click();
        // Egitimin ucretsiz oldugunu test eder ve siparisi tamamlar
        Assert.assertTrue(kayitDogrulama.kayitUcretsizYazisi.isDisplayed());



















    }
}
