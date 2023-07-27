package tests.practice.TestNG;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q6 {



    QdPage qdPage = new QdPage();


    @Test
    public void test01() {

        qdPage = new QdPage();
        // https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");

        // login linkine basin
        qdPage.cookiesKabulButonu.click();
        qdPage.ilkLoginLinki.click();
        // gecerli username, gecersiz password
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void test02() {



        qdPage = new QdPage();
        // https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        // login linkine basin
        qdPage.cookiesKabulButonu.click();
        qdPage.ilkLoginLinki.click();

        // gecersiz username, gecerli password
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void test03() {


        qdPage = new QdPage();
        // https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // login linkine basin
        qdPage.cookiesKabulButonu.click();
        qdPage.ilkLoginLinki.click();


                // gecersiz username, gecersiz password.
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        // Login butonuna basarak login olun
        qdPage.loginButonu.click();
        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }
}
