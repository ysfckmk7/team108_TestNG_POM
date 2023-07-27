package tests.practice.TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q7 {

    @Test
    public void test01(){

        ZeroPage zeroPage=new ZeroPage();

        // “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        // Sign in butonuna basin
        zeroPage.signInButonu.click();
        // Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");
        // Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");
        // Sign in tusuna basin
        zeroPage.signInSubmitButonu.click();
        Driver.getDriver().navigate().back();
        // Online banking menusu icinde Pay Bills sayfasina gidin
        zeroPage.onlineBanking.click();
        zeroPage.payBillLinki.click();
        // “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseFCButonu.click();
        // “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroPage.currencyDropdown);
        select.selectByVisibleText("Eurozone (euro)");
        // soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(zeroPage.currencyDropdown.getText().contains("Eurozone"));
        // soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> optionselemetlistesi=select.getOptions();
        List<String> optionselementstring= ReusableMethods.stringListeCevir(optionselemetlistesi);


        String[] expectedArr={"Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)",
                "Great Britain (pound)","Hong Kong (dollar)",
                "Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)",
                "Sweden (krona)","Singapore (dollar)","Thailand (baht)"};

        List<String> expectedOptionsListesi=new ArrayList<>();

        for (String each:expectedArr
             ) {
            expectedOptionsListesi.add(each);
        }

        softAssert.assertEquals(optionselemetlistesi,expectedOptionsListesi);

        /*"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"*/

        Driver.closeDriver();
    }
}
