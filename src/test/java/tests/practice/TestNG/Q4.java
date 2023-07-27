package tests.practice.TestNG;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class Q4 {



    @Test
    public void test01(){


        //  https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        // POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        // Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        FacebookPage facebookPage=new FacebookPage();
        Faker faker=new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();
        // Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());


        Driver.closeDriver();







    }




}
