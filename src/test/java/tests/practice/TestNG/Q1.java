package tests.practice.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {

    /*
    Navigate to https://www.saucedemo.com/
    Enter the username as standard_user
    Enter the password as secret_sauce
    Click on login buton
         Test1 : Chose price low to high
         Test02 : Verify item prices ara sorted from low to high with soft Assert
     */

    SoftAssert softAssert=new SoftAssert();

    @BeforeTest
    public void login(){

        Driver.getDriver().get("https://www.saucedemo.com/");
        Driver.getDriver().findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Driver.getDriver().findElement(By.xpath("//input[@id='login-button']")).click();




    }

    @Test
    public void SauceTesti1(){

        WebElement dropdown=Driver.getDriver().findElement(By.xpath("//select[@data-test='product_sort_container']"));
        Select select=new Select(dropdown);

        select.selectByVisibleText("Price (low to high)");
        String expectedIcerik="Price (low to high)";
        String actualText=Driver.getDriver().findElement(By.xpath("//span[@class='active_option']")).getText();

        softAssert.assertEquals(actualText,expectedIcerik,"Aktif secenekteki yazi expected datadan farkli!");
        softAssert.assertAll();

    }

    @Test
    public void SauceTesti2(){
        WebElement dropdown=Driver.getDriver().findElement(By.xpath("//select[@data-test='product_sort_container']"));
        Select select=new Select(dropdown);

        select.selectByVisibleText("Price (low to high)");

        List<WebElement> fiyatlar=Driver.getDriver().findElements(By.className("inventory_item_price"));

        ArrayList<Double> fiyatlarDouble =new ArrayList<>();

        for (WebElement fiyat:fiyatlar
        ) {
            String fiyatstr=fiyat.getText().replaceAll("^\\D","");

            fiyatlarDouble.add(Double.valueOf(fiyatstr));
        }


        ArrayList<Double> kontrolList= new ArrayList<>(fiyatlarDouble);
        Collections.sort(kontrolList);
        System.out.println(kontrolList + "\n" + fiyatlarDouble);


        softAssert.assertEquals(fiyatlarDouble,kontrolList,"Siralama gerceklesmemistir");
        softAssert.assertAll();

    }
}
